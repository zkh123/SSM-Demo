package com.ssm.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    /**
     * 跳转到页面
     * @return
     */
    @RequestMapping("/toLogin")
    private String toPage(){
        return "login";
    }

    @RequestMapping(value = "/home")
    @ResponseBody
    public String home(){
        return "ok";
    }
}
