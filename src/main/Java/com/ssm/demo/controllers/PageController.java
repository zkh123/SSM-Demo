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
    @RequestMapping("/page")
    private String toPage(){
        return "error";
    }

    @RequestMapping(value = "/home")
    @ResponseBody
    public String home(){
        return "ok";
    }
}
