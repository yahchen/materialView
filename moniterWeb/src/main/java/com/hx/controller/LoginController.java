package com.hx.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyaohui on 2017/7/20.
 */
@Controller
public class LoginController {
    @RequestMapping("/index")//对应url
    public String login(HttpServletRequest request,ModelAndView mv){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        Object usr = request.getParameter("usr");
        Object pwd = request.getParameter("pwd");
        mv.addObject("data",new Object());
        if(null == usr && null == pwd)
            return "login";//对应templates里的login.html
        else
            return "index";
    }

    @RequestMapping("/mapTest")//对应url
    public ModelAndView map(){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        ModelAndView mv = new ModelAndView("mapExample");
        return mv;//对应templates里的login.html
    }

}
