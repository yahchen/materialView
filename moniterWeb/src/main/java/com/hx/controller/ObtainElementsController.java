package com.hx.controller;

import com.hx.service.BinMapDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class ObtainElementsController {

    @Autowired
    private BinMapDataService binMapDataService;

    @RequestMapping("/getElements")//对应url
    @ResponseBody
    public List<Map<String,Object>> elements(HttpServletRequest request){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv

        String dataType = request.getParameter("dataType");
        String qualiteType = request.getParameter("qualiteType");

        long time = Long.valueOf(StringUtils.isEmpty(request.getParameter("startTime"))?System.currentTimeMillis()+"":request.getParameter("startTime"));
        Timestamp st = new Timestamp(time);




        Map<String,Object> elements = new HashMap<>();
        //测试开发阶段可以手动set字段做测试-----start
        List<String> sidList = new ArrayList<>();
        elements.put("Station_Id_d",sidList);
        List<String> latList = new ArrayList<>();
        elements.put("Lat",latList);
        List<String> lonList = new ArrayList<>();
        elements.put("Lon",lonList);
        List<String> altiList = new ArrayList<>();
        elements.put("Alti",altiList);
        List<String> stList = new ArrayList<>();
        elements.put("Station_type",stList);


        sidList.add("999999.00");
        latList.add("42.01");
        lonList.add("120.12");
        altiList.add("900");
        stList.add("1");
        //ceshi-----------------------end
        String table = convertDataType2Table(dataType);
        if(StringUtils.isEmpty(table))
            return null;

        return binMapDataService.queryBinMapData(table,st,qualiteType);
    }

    private String convertDataType2Table(String dataType) {
        if(!StringUtils.isEmpty(dataType)){
            if("0".equals(dataType))
                return "tm_site_surf_1h";//test
            return dataType.toLowerCase().replace("m_r","m_site_");
        }
        return null;//test
    }
}
