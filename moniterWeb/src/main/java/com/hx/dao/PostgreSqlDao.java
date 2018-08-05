package com.hx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yahchen on 2017/10/31.
 */
@Repository
public class PostgreSqlDao {
    @Autowired
    @Qualifier("postgresJdbcTemplate")
    private JdbcTemplate template;

    @Value("${two.dimensional.distribution.map.point.limit.num:1000}")
    private int limitNum;

    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate namedTemplate;

    public List<Map<String, Object>> queryBinMapData(String table, String neLat, String neLon, String swLat, String swLon, String prs, String sdid) {
        Map<String, Object> params = new HashMap<>();
        String sql = "SELECT * FROM " + table + " WHERE s_d_id = :sdid AND lat > :swLat AND lat < :neLat AND lon > :swLon AND lon < :neLon ";
        if (!StringUtils.isEmpty(prs)) {
            if (table.contains("temp")) {
                sql += "AND prs_hwc = :prs ";
            } else {
                sql += "AND prs > :prs ";
            }
            params.put("prs", Float.parseFloat(prs));
        }
        sql += " limit :limitNum";
        params.put("limitNum", limitNum);
        params.put("swLat", Float.valueOf(swLat));
        params.put("neLat", Float.valueOf(neLat));
        params.put("swLon", Float.valueOf(swLon));
        params.put("neLon", Float.valueOf(neLon));
        params.put("sdid", Float.valueOf(StringUtils.isEmpty(sdid) ? "0" : sdid));
        return namedTemplate.queryForList(sql, params);
    }

    public List<Map<String, Object>> queryBinQualiteTypeData(String table, String dataType) {
        String sql = "select * from " + table + " where data_logo_type = :dataType";
        Map<String, Object> params = new HashMap<>();
        params.put("dataType", dataType);
        return namedTemplate.queryForList(sql, params);
    }

    /**
     * 返回某时间段内所有卫星文件名（中的时间）
     *
     * @param table
     * @param queryTime
     * @return
     */
    public List<Map<String, Object>> querySatelliteTimeRangeBinMapData_right(String table, Timestamp queryTime) {
        // Map para = new HashMap();
        String sql = "select distinct file_name_time from \"" + table;
        if (!queryTime.equals("null")) {
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String startTime = sdf.format(queryTime) + " 00:00:00";
            String endTime = sdf.format(queryTime) + " 23:59:59";
            sql += "\" where file_name_time between " + startTime + " and " + endTime + ";";
        }
        return template.queryForList(sql);

    }

    /**
     * 返回某时间段内所有卫星文件名（中的时间）
     *
     * @param table
     * @param querySatelliteDate
     * @return
     */
    public List<Map<String, Object>> querySatelliteTimeRangeBinMapData(String table, String querySatelliteDate) {

        String yesterdayQuerySatelliteDate =null;
        Map para = new HashMap();
        //String sql = "select distinct file_name_time from \"" + table;
        String sql = "select distinct file_name_time from " + table;
        if (!querySatelliteDate.equals("null")) {
            Timestamp startTime = new Timestamp(System.currentTimeMillis());
            Timestamp endTime = new Timestamp(System.currentTimeMillis());

            Date date1 = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date1 = sdf.parse(querySatelliteDate);
                Calendar c = Calendar.getInstance();
                c.setTime(date1);
                c.add(Calendar.DAY_OF_MONTH, -1);// 今天-1天
                Date date2 = c.getTime();
                yesterdayQuerySatelliteDate =  sdf.format(date2);

            } catch (Exception e) {
                e.printStackTrace();
            }
            startTime = Timestamp.valueOf(yesterdayQuerySatelliteDate + " 21:00:00");
            endTime = Timestamp.valueOf(querySatelliteDate + " 20:59:59");

            //sql += "\" where file_name_time between :startTime and :endTime";
            sql += " where file_name_time between :startTime and :endTime";
            para.put("startTime", startTime);
            para.put("endTime", endTime);
        }
        List<Map<String, Object>> listTime = namedTemplate.queryForList(sql, para);

        // 根据时间,构建卫星文件名
        //List<Map<String, Object>> tt = getSatelliteFileTimes(table, listTime);

        // 根据时间,构建卫星文件时次
        List<Map<String, Object>> tt = getSatelliteTimes(yesterdayQuerySatelliteDate,querySatelliteDate,table, listTime);
        return tt;
    }

    // 根据时间,构建卫星文件时次
    public List<Map<String, Object>> getSatelliteTimes(String yesterdayQuerySatelliteDate,String querySatelliteDate,String table, List<Map<String, Object>> listTime) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime00 =null;
        Date endTime00 =null;
        Date startTime06 =null;
        Date endTime06 =null;
        Date startTime12 =null;
        Date endTime12 =null;
        Date startTime18 =null;
        Date endTime18 =null;

        // 判断该表中是否有某天的数据，如果有size>0,没有的时候size=0
        if (listTime.size() > 0) {
            try {
                startTime00 = sdf.parse(yesterdayQuerySatelliteDate + " 21:00:00");
                endTime00 = sdf.parse(querySatelliteDate + " 02:59:59");
                startTime06 = sdf.parse(querySatelliteDate + " 03:00:00");
                endTime06 = sdf.parse(querySatelliteDate + " 08:59:59");
                startTime12 = sdf.parse(querySatelliteDate + " 09:00:00");
                endTime12 = sdf.parse(querySatelliteDate + " 14:59:59");
                startTime18 = sdf.parse(querySatelliteDate + " 15:00:00");
                endTime18 = sdf.parse(querySatelliteDate + " 20:59:59");
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }

            for (Map<String, Object> m : listTime) {
                for (String k : m.keySet()) {
                    String sTime =  sdf.format(m.get(k)) ;                   // 拼接后的字符串（卫星文件名）
                    try {
                        Date sDate = sdf.parse(sTime);
                        // 替换 原有时间戳 为 拼接后的字符串（卫星文件名）
                        if(belongCalendar(sDate, startTime00, endTime00)){
                            m.replace(k, m.get(k), "00时次");
                        }else if(belongCalendar(sDate, startTime06, endTime06)){
                            m.replace(k, m.get(k), "06时次");
                        }else if(belongCalendar(sDate, startTime12, endTime12)){
                            m.replace(k, m.get(k), "12时次");
                        }else if(belongCalendar(sDate, startTime18, endTime18)){
                            m.replace(k, m.get(k), "18时次");
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        e.printStackTrace();
                    }
                }
            }//end for

            // 去除重复的值 例如：两个“00时次”，去掉一个
            List<Map<String,Object>> listTime2 = new LinkedList<Map<String,Object>>();
            Set<Map> setMap = new HashSet<Map>();
            for(Map<String,Object> map1 : listTime){
                if(setMap.add(map1)){
                    listTime2.add(map1);
                }
            }
            return listTime2;
        }
        return listTime;
    }

    /**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }


/*       备份 2018/03/20
    // 根据时间,构建卫星文件名
    public List<Map<String, Object>> getSatelliteFileTimes(String table, List<Map<String, Object>> listTime) {

        String satelliteFileName = "";

        // 判断该表中是否有某天的数据，如果有size>0,没有的时候size=0
        if (listTime.size() > 0) {

            if ("AMSUA_NOAA15".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUA-045KM-BAWX-";
            } else if ("AMSUA_NOAA18".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-AMSUA-045KM-BAWX-";
            } else if ("AMSUA_NOAA19_BAWX".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-BAWX-";
            } else if ("AMSUA_NOAA19_EUMP".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMP-PROC-";
            } else if ("AMSUA_NOAA19_EUMS".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-AMSUA-045KM-EUMS-EUMS-EATH-PROC-";
            } else if ("AMSUA_MTB_EUMP".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMP-PROC-";
            } else if ("AMSUA_MTB_EUMS".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-AMSUA-045KM-EUMS-EUMS-EEDM-PROC-";
            } else if ("AMSUA_MTA_EUMC".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMC-PROC-";
            } else if ("AMSUA_MTA_EUMS".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-AMSUA-045KM-EUMS-EUMS-EMAS-PROC-";
            } else if ("AMSUB_NOAA15".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N15-AMSUB-015KM-BAWX-";
            } else if ("MHS_NOAA18".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N18-MHS-015KM-BAWX-";
            } else if ("MHS_NOAA19".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-N19-MHS-015KM-BAWX-";
            } else if ("MHS_MTB".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTA-MHS-015KM-EUMC-PROC-";
            } else if ("MHS_MTA".equals(table)) {
                satelliteFileName = "SATE_L1_MUS_ATOVS_MWB_S1C_GLB-MTB-MHS-015KM-EUMP-PROC-";
            } else if ("IASI_MTA".equals(table)) {
                satelliteFileName = "SATE_L1_MTA_IASI_MWB_RED_GLB-EUMP-";
            } else if ("IASI_MTB".equals(table)) {
                satelliteFileName = "";     //添加文件名称
            } else if ("GNSS_MTB".equals(table)) {
                satelliteFileName = "SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTB-EKMI-";
            } else if ("GNSS_MTA".equals(table)) {
                satelliteFileName = "SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-MTA-EKMI-";
            } else if ("GNSS_TDMX".equals(table)) {
                satelliteFileName = "SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TDMX-EDZW-";
            } else if ("GNSS_TASR".equals(table)) {
                satelliteFileName = "SATE_L2_MUS_MUTDS_NUL_GNSS_GLB-TSAR-EDZW-";
            } else if ("ASCAT_MTA".equals(table)) {
                satelliteFileName = "SATE_L1_MTA_ASCAT_MWB_S1C_GLB-025KM-GLB-EHDB-";
            } else if ("ASCAT_MTB".equals(table)) {
                satelliteFileName = "";
            } else {
                // 添加新的内容
                satelliteFileName = "";
            }
        }

        // 根据时间构建卫星文件名
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd'-'HHmmss");
        for (Map<String, Object> m : listTime) {
            for (String k : m.keySet()) {
                String sTime = satelliteFileName + sdf.format(m.get(k)) + ".BIN";        // 拼接后的字符串（卫星文件名）
                m.replace(k, m.get(k), sTime);                                              // 替换 原有时间戳 为 拼接后的字符串（卫星文件名）
            }
        }
        return listTime;
    }
*/




    /**
     * 返回某文件名中时间点的所有经纬度坐标值(用于查询一个时间段中所有的点)   ,最新完善 2018/03/20
     *
     * @param table
     * @param startTime
     * @param endTime
     * @param querySatelliteTime
     * @return
     */
    public List<Map<String, Object>> querySatelliteBinMapData(String table, Timestamp startTime, Timestamp endTime,String querySatelliteTime) {
        Map para = new HashMap();
        String sql = "select obs_lat,obs_lon from " + table;
        if ((!startTime.equals("null")) &&(!endTime.equals("null"))) {
            sql += " where file_name_time between \'" + startTime + "\' and \'" + endTime  + "\';";
        }
        List<Map<String, Object>> ss = template.queryForList(sql);

        return ss;
    }

    /**
     * 返回某文件名中时间点的所有经纬度坐标值(用于查询一个文件中所有的点)
     *
     * @param table
     * @param stDate
     * @param querySatelliteTime
     * @return
     */
    public List<Map<String, Object>> querySatelliteBinMapData(String table, Timestamp stDate,String querySatelliteTime) {
        Map para = new HashMap();
        //String sql = "select obs_lat,obs_lon from \""  + table;
        String sql = "select obs_lat,obs_lon from " + table;
        if (!stDate.equals("null")) {
            // sql += "\" where file_name_time = \'" +stDate + "\';";
            sql += " where file_name_time = \'" + stDate + "\';";
        }
        List<Map<String, Object>> ss = template.queryForList(sql);
        return ss;
    }


    public List<Map<String, Object>> queryTimeHours(String dataLogo, Timestamp startTime, Timestamp endTime) {
        Map para = new HashMap();
        para.put("dataLogo", dataLogo);
        para.put("startTime", startTime);
        para.put("endTime", endTime);

        String sql = "select id,data_time from site_data_head where data_time BETWEEN :startTime and :endTime AND data_logo = :dataLogo";
        return namedTemplate.queryForList(sql, para);
    }

}
