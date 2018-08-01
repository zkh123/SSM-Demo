package com.ssm.demo.controllers;


import com.alibaba.fastjson.JSONObject;
import com.ssm.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody User user){
        System.out.println(JSONObject.toJSONString(user));
        JSONObject param = new JSONObject();
        param.put("flag","login success");
        return param;
    }
}
