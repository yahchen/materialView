package com.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class ObtainElementsController {
    @RequestMapping("/getElements")//对应url
    @ResponseBody
    public Map<String,Object> elements(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
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
        return elements;
    }
}
