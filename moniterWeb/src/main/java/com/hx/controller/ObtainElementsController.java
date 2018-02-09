package com.hx.controller;

import com.hx.service.BinMapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.MapUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class ObtainElementsController {

    @Autowired
    private BinMapDataService binMapDataService;

    @RequestMapping("/track_map_view")//对应url
    public String trackMapView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "trackmap/track_map";
    }



    @RequestMapping("/distribution_curve_view")//对应url
    public String distributionCurveView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "distributionCurve/distribution_curve";
    }

    @RequestMapping("/getElements")//对应url
    @ResponseBody
    public List<Map<String, Object>> elements(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv

        String dataType = request.getParameter("dataType");
        String neLon = request.getParameter("neLon");
        String neLat = request.getParameter("neLat");
        String swLon = request.getParameter("swLon");
        String swLat = request.getParameter("swLat");
        String prs = request.getParameter("prs");
        String sdid = request.getParameter("sdid");

        String table = convertDataType2Table(dataType);
        if (StringUtils.isEmpty(table))
            return null;
        List<Map<String, Object>> resList = binMapDataService.queryBinMapData(table, neLat, neLon, swLat, swLon, prs,sdid);
        return resList;
    }
    @RequestMapping("getTimeHours")
    @ResponseBody
    public Map<String,String> getTimeHours(HttpServletRequest request){
        String dataLogo = request.getParameter("dataType");
        String startTime = request.getParameter("startTime");
        Timestamp start,end;
        if(!StringUtils.isEmpty(startTime)){
            start = Timestamp.valueOf(startTime + " 00:00:00");
            end = Timestamp.valueOf(startTime + " 23:59:59");
        }else {
            start = Timestamp.valueOf(new Date().toString());
            end = Timestamp.valueOf(addDays(start,1).toString());
        }
        return convertDbRes2TimeHours(binMapDataService.queryTimeHousr(dataLogo.replaceAll("M_R","M_"),start,end));
    }

    private Map<String,String> convertDbRes2TimeHours(List<Map<String, Object>> resData) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        if(CollectionUtils.isEmpty(resData))
            return Collections.EMPTY_MAP;
        Map<String,String> timeHoursMap = new HashMap<>();
        for(Map<String,Object> tableLine:resData){
            Timestamp dataTime = (Timestamp)tableLine.get("data_time");
            if(dataTime == null)
                continue;
            String sdid = tableLine.get("id").toString();
            int hour = dataTime.getHours();
            timeHoursMap.put(sdid,hour<=9?"0"+hour:hour+"");
        }
        return timeHoursMap;
    }

    @RequestMapping("/getQualiteTypes")
    @ResponseBody
    public List<Map<String, Object>> getQualiteTypes(HttpServletRequest request) {
        String dataType = request.getParameter("dataType");
        return binMapDataService.queryBinQualiteTypeData("type_and_element_mapping", dataType);
    }


    @RequestMapping("/getSatelliteTimeRangElements")//对应url
    @ResponseBody
    public List<Map<String, Object>> satelliteTimeRangElements(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        String satelliteType = request.getParameter("satelliteType");
        String querySatelliteDate = request.getParameter("querySatelliteDate");
        // Timestamp ts = new Timestamp(System.currentTimeMillis());
        // ts = Timestamp.valueOf(querySatelliteDate);
        //String table = convertSatelliteDataType2Table(satelliteType);
        String table = satelliteType;
        if (StringUtils.isEmpty(table))
            return null;

        return binMapDataService.querySatelliteTimeRangeBinMapData(table, querySatelliteDate);
    }


    @RequestMapping("/getSatelliteElements")//对应url
    @ResponseBody
    public List<Map<String, Object>> satelliteElements(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv

        String querySatelliteDate = request.getParameter("querySatelliteDate");
        String satelliteType = request.getParameter("satelliteType");

        String querySatelliteTime = request.getParameter("querySatelliteTime");

        // 将卫星时次querySatelliteTime中的时间提取出来
        String strTime = "";
        Timestamp stDate = new Timestamp(System.currentTimeMillis());
        if (querySatelliteTime != null && !"".equals(querySatelliteTime)) {

            Pattern p = Pattern.compile("\\d{6,}"); // 这个6是指连续数字的最少个数
            Pattern p1 = Pattern.compile("\\d{7,}"); // 这个7是指连续数字的最少个数
            Pattern p2 = Pattern.compile("\\d{6,}"); // 这个7是指连续数字的最少个数
            Matcher m = p.matcher(querySatelliteTime);

            int i = 0;
            while (m.find()) {
                System.out.println(m.group());
                strTime += m.group();
                i++;
            }

            //yyyyMMddHHmmss时间格式怎么转化为yyyy-MM-dd HH:mm:ss
            String reg = "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})";
            strTime = strTime.replaceAll(reg, "$1-$2-$3 $4:$5:$6");


            // 根据时间构建卫星文件名
            //  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            // stDate = Timestamp.valueOf(strTime);
            // String ss = sdf.format(strTime);
            stDate = Timestamp.valueOf(strTime);


            /*
            for(int i=0;i<querySatelliteTime.length();i++){
                if(querySatelliteTime.charAt(i)>=48 && querySatelliteTime.charAt(i)<=57){
                    strTime+=querySatelliteTime.charAt(i);
                }
            }*/
        }

        //long time = Long.valueOf(StringUtils.isEmpty(request.getParameter("querySatelliteDate"))?System.currentTimeMillis()+"":request.getParameter("querySatelliteDate"));

        //long time = Long.valueOf(StringUtils.isEmpty(strTime)?System.currentTimeMillis()+"":strTime);
        // Timestamp stDate = new Timestamp(time);

        //String table = convertSatelliteDataType2Table(satelliteType);


        String table = satelliteType;
        if (StringUtils.isEmpty(table))
            return null;
        return binMapDataService.querySatelliteBinMapData(table, stDate, querySatelliteTime);
    }

    private String convertSatelliteDataType2Table(String dataType) {
        if (!StringUtils.isEmpty(dataType)) {
            if ("0".equals(dataType)) {
                return "AMSUA_NOAA15";//test
            } else if ("1".equals(dataType)) {
                return "AMSUA_NOAA18";
            } else if ("2".equals(dataType)) {
                return "AMSUA_NOAA19_BAWX";
            } else if ("3".equals(dataType)) {
                return "AMSUA_NOAA19_EUMP";
            } else if ("4".equals(dataType)) {
                return "AMSUA_NOAA19_EUMS";
            } else if ("5".equals(dataType)) {
                return "AMSUB_NOAA15";
            } else if ("6".equals(dataType)) {
                return "MHS_NOAA19";
            }

            return dataType.toLowerCase().replace("m_r", "m_site_");
        }
        return null;//test
    }

    private String convertDataType2Table(String dataType) {
        if (!StringUtils.isEmpty(dataType)) {
            if ("0".equals(dataType))
                return "tm_site_surf_1h";//test
            return dataType.toLowerCase().replace("m_r", "m_site_");
        }
        return null;//test
    }

    private Timestamp convertStr2TimeStamp(String startTime){
        if (!StringUtils.isEmpty(startTime)) {
            if (!startTime.contains(":")) {
                startTime += " 00:00:00.000";
            }
        }
        return Timestamp.valueOf(StringUtils.isEmpty(startTime) ? System.currentTimeMillis() + "" : startTime);
    }

    public static Date addDays(Date date, int addedDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(5, addedDays);
        return cal.getTime();
    }
}
