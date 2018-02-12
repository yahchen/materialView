package com.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class MaterialViewController {
    @RequestMapping("/index.vo")//对应url
    public String indexVo() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "index";
    }

    @RequestMapping("/index")//对应url
    public String index() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        return "index";
    }

    @RequestMapping("/about")//对应url
    public String about() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "about-sys";
    }

    @RequestMapping("/gm_data")//对应url
    public String gm_data(HttpServletRequest request) {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        request.getParameterValues("user");
        return "GMdata";
    }

    @RequestMapping("/rm_data")//对应url
    public String rm_data() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "RMdata";
    }

    @RequestMapping("/tm_data")//对应url
    public String tm_data() {//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "TMdata";
    }

    //index页面的一些跳转页面方法

}
