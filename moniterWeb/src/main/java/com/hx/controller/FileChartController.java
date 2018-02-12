package com.hx.controller;

import com.hx.service.FileChartService;
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
public class FileChartController {

    @Autowired
    @Qualifier("fileChartServiceImpl")
    private FileChartService fileChartService;

    @RequestMapping("/sate_file_chart_view")//对应url
    public String siteChartView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "file/sate_file_chart";
    }

    @RequestMapping("/findSateFileSelectdByTimeElement")//对应url
    @ResponseBody
    public Map<String, Object> findSateFileSelectdByTimeElement(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String queryElment = request.getParameter("dataLogo");
        List<Map<String, Object>> sateFileSelectDataList = fileChartService.findSateFileSelectdByTimeElement(startTime, endTime, queryElment);
        Map<String, Object> map = new HashMap();
        String jsonMessage = "";
        if (sateFileSelectDataList.size() <= 0) {
            jsonMessage += startTime.substring(0, 10) + "～" + endTime.substring(0, 10) + "无数据！";
        }
        map.put("sateFileSelectDataList", sateFileSelectDataList);
        map.put("jsonMessage", jsonMessage);
        return map;
    }

    @RequestMapping("/findSateFileChartByTimeElement")//对应url
    @ResponseBody
    public Map<String, Object> findSateChartByTimeElement(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String queryElment = request.getParameter("dataLogo");
        String sateName = request.getParameter("sateName");

        List<Map<String, Object>> steaFileDataList = fileChartService.findSateFileChartByTimeElement(startTime, endTime, queryElment, sateName);
        DateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");//提示的格式
        DateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时");//x轴显示的样式
        String strMessage = startTime.substring(0, 10) + "～" + endTime.substring(0, 10);
        Map jsonMap = new HashMap();
        List jsonTime = new ArrayList();
        List jsonTime1 = new ArrayList();
        List jsonDay = new ArrayList();
        List jsonNum = new ArrayList<>();
        List jsonProcessTime = new ArrayList<>();
        if (steaFileDataList.size() > 0) {
            for (Map<String, Object> map : steaFileDataList) {

                jsonTime.add(sdf1.format(map.get("data_time")));//资料时间点 年月日
                jsonTime1.add(sdf2.format(map.get("data_time")));//资料时间  年月日 时
                jsonNum.add(map.get("sate_file_num"));//文件数
                jsonProcessTime.add(map.get("retrieve_process_time"));//每类资料检索耗时
            }
            strMessage += "折线图如下：";
        } else {
            strMessage += "无数据！";
        }

        jsonMap.put("jsonTime", jsonTime);//X轴数据
        jsonMap.put("jsonTime1", jsonTime1);//点的提示数据
        jsonMap.put("jsonNum", jsonNum);//站点数
        jsonMap.put("jsonProcessTime", jsonProcessTime);//检索耗时
        jsonMap.put("jsonMessage", strMessage);//span提示信息
        return jsonMap;
    }

    @RequestMapping("/file_chart_view")//对应url
    public String fileChartView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "file/file_chart";
    }

    @RequestMapping("/findFileChartByTimeElement")//对应url
    @ResponseBody
    public Map<String, Object> findFileChartByTimeElement(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String queryElment = request.getParameter("dataLogo");

        if (("".equals(startTime) || null == startTime) || ("".equals(endTime) || null == endTime)) {//点击查询按钮不会出现这种情况，唯一这种情况是点击菜单按钮，初始化
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -1);
            endTime = sdf.format(new Date());
            startTime = sdf.format(cal.getTime()) + " 00:00:00";
        }

        List<Map<String, Object>> fileDataList = fileChartService.findFileChartByTimeElement(startTime, endTime, queryElment);
        DateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");//提示的格式
        DateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH时");//x轴显示的样式
        String strMessage = startTime.substring(0, 10) + "～" + endTime.substring(0, 10);
        Map jsonMap = new HashMap();
        List jsonTime = new ArrayList();
        List jsonTime1 = new ArrayList();
        List jsonDay = new ArrayList();
        List jsonNum = new ArrayList<>();
        List jsonProcessTime = new ArrayList<>();
        if (fileDataList.size() > 0) {
            for (Map<String, Object> map : fileDataList) {

                jsonTime.add(sdf1.format(map.get("data_time")));//资料时间点 年月日
                jsonTime1.add(sdf2.format(map.get("data_time")));//资料时间  年月日 时
                jsonNum.add(map.get("data_num"));//文件数
                jsonProcessTime.add(map.get("retrieve_process_time"));//每类资料检索耗时
            }
            strMessage += "折线图如下：";
        } else {
            strMessage += "无数据！";
        }

        jsonMap.put("jsonTime", jsonTime);//X轴数据
        jsonMap.put("jsonTime1", jsonTime1);//点的提示数据
        jsonMap.put("jsonNum", jsonNum);//站点数
        jsonMap.put("jsonProcessTime", jsonProcessTime);//检索耗时
        jsonMap.put("jsonMessage", strMessage);//span提示信息
        jsonMap.put("jsonTotal", fileDataList.size());
        return jsonMap;
    }
}
