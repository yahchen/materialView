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
        String table = convertDataType2Table(dataType);
        if(StringUtils.isEmpty(table))
            return null;

        return binMapDataService.queryBinMapData(table,st,qualiteType);
    }

    @RequestMapping("/getQualiteTypes")
    @ResponseBody
    public List<Map<String,Object>> getQualiteTypes(HttpServletRequest request){
        String dataType = request.getParameter("dataType");
        return binMapDataService.queryBinQualiteTypeData("type_and_element_mapping",dataType);
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
