package com.hx.controller;

import com.hx.service.GridChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hp on 2017/10/31.
 */
@Controller
public class SateTrackMapController {

    @Autowired
    @Qualifier("gridChartServiceImpl")
    private GridChartService gridChartService;

    @RequestMapping("/track_map")//对应url
    public String gridChartView() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "trackmap/track_map";
    }


}
