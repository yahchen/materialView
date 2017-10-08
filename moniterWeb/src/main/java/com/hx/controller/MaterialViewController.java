package com.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yahchen on 2017/10/8.
 */
@Controller
public class MaterialViewController {
    @RequestMapping("/index.vo")//对应url
    public String indexVo(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "index";
    }

    @RequestMapping("/about")//对应url
    public String about(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "about-sys";
    }

    @RequestMapping("/data")//对应url
    public String data(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "data_final";
    }

    @RequestMapping("/elements")//对应url
    public String elements(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "elements1";
    }
}
