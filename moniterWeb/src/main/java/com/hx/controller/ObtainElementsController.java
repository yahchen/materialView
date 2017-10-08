package com.hx.controller;

import com.hx.bean.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class ObtainElementsController {
    @RequestMapping("/getElements")//对应url
    public Elements elements(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        Elements elements = new Elements();
        //测试开发阶段可以手动set字段做测试-----start
        elements.addKey("Station_Id_d");
        elements.addKey("Lat");
        elements.addKey("Lon");
        elements.addKey("Alti");
        elements.addKey("Station_type");
        List<String> vele = new ArrayList<>();
        vele.add("999999.00");
        vele.add("42.01");
        vele.add("120.12");
        vele.add("900");
        vele.add("1");
        elements.addValue(vele);
        //ceshi       -----------------------end
        return elements;
    }
}
