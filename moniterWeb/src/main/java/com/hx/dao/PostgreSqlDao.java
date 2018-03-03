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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map para = new HashMap();
        //String sql = "select distinct file_name_time from \"" + table;
        String sql = "select distinct file_name_time from " + table;
        if (!querySatelliteDate.equals("null")) {

            Timestamp startTime = new Timestamp(System.currentTimeMillis());
            Timestamp endTime = new Timestamp(System.currentTimeMillis());
            startTime = Timestamp.valueOf(querySatelliteDate + " 00:00:00");
            endTime = Timestamp.valueOf(querySatelliteDate + " 23:59:59");
            //sql += "\" where file_name_time between :startTime and :endTime";
            sql += " where file_name_time between :startTime and :endTime";
            para.put("startTime", startTime);
            para.put("endTime", endTime);
        }
        List<Map<String, Object>> listTime = namedTemplate.queryForList(sql, para);

        // 根据时间,构建卫星文件名
        List<Map<String, Object>> tt = getSatelliteFileTimes(table, listTime);
        return tt;
    }

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


    /**
     * 返回某文件名中时间点的所有经纬度坐标值
     *
     * @param table
     * @param stDate
     * @param querySatelliteTime
     * @return
     */
    public List<Map<String, Object>> querySatelliteBinMapData(String table, Timestamp stDate, String querySatelliteTime) {
        Map para = new HashMap();
        //String sql = "select obs_lat,obs_lon from \""  + table;
        String sql = "select obs_lat,obs_lon from " + table;
        if (!stDate.equals("null")) {

            // sql += "\" where file_name_time = \'" +stDate + "\';";
            sql += " where file_name_time = \'" + stDate + "\';";
        }
        // sql += "\" where file_name_time between :startTime and :endTime";
        // para.put("startTime", stDate);
        //para.put("endTime", stDate);
        // }
        //List<Map<String,Object>> listTime = namedTemplate.queryForList(sql,para);
        //List<Map<String,Object>> tt =  namedTemplate.queryForList(sql,para);

        // sql += "\" where file_name_time == " +stDate + ";";
        List<Map<String, Object>> ss = template.queryForList(sql);

        return ss;
        //return namedTemplate.queryForList(sql,para);
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
