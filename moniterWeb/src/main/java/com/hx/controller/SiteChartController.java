package com.hx.controller;

import com.hx.service.SiteChartService;
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
public class SiteChartController {

    @Autowired
    @Qualifier("siteChartServiceImpl")
    private SiteChartService siteChartService;

    @RequestMapping("/site_chart_view")//对应url
    public String siteChartView(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "site/site_chart";
    }

    @RequestMapping("/findSiteChartByTimeElement")//对应url
    @ResponseBody
    public Map<String,Object> findSiteChartByTimeElement(HttpServletRequest request){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startTime=request.getParameter("startTime");
        String endTime=request.getParameter("endTime");
        String strZone=request.getParameter("strZone");
        String queryElment=request.getParameter("dataLogo");
        //startTime endTime两者全不为空，则按时间查，否则有一个为空，则按时区查
        if(("".equals(startTime)||null==startTime)||("".equals(endTime)||null==endTime)){
            if("0".equals(strZone)){
                strZone="4";
            }
            endTime=sdf.format(new Date());
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE, -Integer.parseInt(strZone)*7);
            startTime=sdf.format(cal.getTime());
            }
    List<Map<String, Object>> siteDataList=siteChartService.findSiteChartByTimeElement(startTime,endTime,queryElment);
        DateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        String strMessage=startTime + "～" + endTime;
        Map jsonMap=new HashMap();
        List  jsonTime=new ArrayList();
        List  jsonDay=new ArrayList();
        List jsonNum=new ArrayList<>();
        if(siteDataList.size()>0){
            for( Map<String, Object> map:siteDataList){

                jsonTime.add(sdf1.format(map.get("data_time")));
                jsonNum.add(map.get("data_num"));
            }
            strMessage+="折线图如下：";
        }else{
            strMessage+="无数据！";
        }

        jsonMap.put("jsonTime", jsonTime);
        jsonMap.put("jsonNum", jsonNum);
        jsonMap.put("jsonMessage",strMessage);
        return jsonMap;
    }
}
