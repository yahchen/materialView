package com.hx.controller;

import com.hx.service.GridChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hp on 2017/10/31.
 */
@Controller
public class GridChartController {

    @Autowired
    @Qualifier("gridChartServiceImpl")
    private GridChartService gridChartService;

    @RequestMapping("/grid_chart_view")//对应url
    public String gridChartView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "grid/grid_chart";
    }

    @RequestMapping("/findGridChartByTimeElement")//对应url
    @ResponseBody
    public Map<String, Object> findGridChartByTimeElement(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String strZone = request.getParameter("strZone");
        String queryElment = request.getParameter("dataLogo");
        //startTime endTime两者全不为空，则按时间查，否则有一个为空，则按时区查
        if (("".equals(startTime) || null == startTime) || ("".equals(endTime) || null == endTime)) {
            Calendar cal = Calendar.getInstance();
            if ("0".equals(strZone) || "4".equals(strZone)) {
                //strZone="4";
                cal.add(Calendar.MONTH, -1);
            } else {
                cal.add(Calendar.DATE, -Integer.parseInt(strZone) * 7);
            }
            endTime = sdf.format(new Date());
            startTime = sdf.format(cal.getTime()) + " 00:00:00";
        }
        List<Map<String, Object>> gridDataList = gridChartService.findGridChartByTimeElement(startTime, endTime, queryElment);
        DateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        DateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时");
        String strMessage = startTime.substring(0, 10) + "～" + endTime.substring(0, 10);
        Map jsonMap = new HashMap();
        List jsonTime = new ArrayList();
        List jsonTime1 = new ArrayList();
        List jsonDay = new ArrayList();
        List jsonNum = new ArrayList<>();
        List jsonProcessTime = new ArrayList<>();
        if (gridDataList.size() > 0) {
            for (Map<String, Object> map : gridDataList) {

                jsonTime.add(sdf1.format(map.get("data_time")));//资料时间点 年月日
                jsonTime1.add(sdf2.format(map.get("data_time")));//资料时间  年月日 时
                jsonNum.add(getFileNum((String) map.get("data_num")));//站点数
                jsonProcessTime.add(map.get("retrieve_process_time"));//每类资料检索耗时
            }
            strMessage += "折线图如下：";
        } else {
            strMessage += "无数据！";
        }

        jsonMap.put("jsonTime", jsonTime);//X轴数据
        jsonMap.put("jsonTime1", jsonTime1);//点的提示数据
        jsonMap.put("jsonNum", jsonNum);//文件数
        jsonMap.put("jsonProcessTime", jsonProcessTime);//检索耗时
        jsonMap.put("jsonMessage", strMessage);//span提示信息
        return jsonMap;
    }

    private int getFileNum(String dataNum) {//计算格点文件数据
        int fileNum = 0;
        if (dataNum != null && !"".equals(dataNum)) {
            String[] strArray = dataNum.split(",");
            for (int i = 0; i < strArray.length; i++) {
                fileNum += Integer.parseInt(strArray[i]);
            }
        }
        return fileNum;
    }
}
