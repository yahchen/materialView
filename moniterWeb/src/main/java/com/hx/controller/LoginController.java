package com.hx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyaohui on 2017/7/20.
 */
@Controller
public class LoginController {
    @RequestMapping("login")//对应url
    public String login(HttpServletRequest request, Model model){//参数可以选择性添加，不加也无所谓。如果添加后，框架会帮助自动注入。
        // todo add mode kv
        return "login";//对应templates里的login.html
    }
}
