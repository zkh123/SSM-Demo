package com.ssm.demo.controllers;

import com.alibaba.fastjson.JSONObject;
import com.ssm.demo.entity.DataVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
    @RequestMapping("/update")
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值
    public Map<String,Object> update(Long num, Long id, BigDecimal amount){

        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(num == null || id == null || amount == null){
            resultMap.put("result", "参数不合法！");
            return resultMap;
        }
        //xxx逻辑处理
        resultMap.put("result", "SUCCESS");
        return resultMap;
    }


    @RequestMapping("/add")
    @ResponseBody//此处不能省略 否则ajax无法解析返回值
    public Map<String,Object> add(DataVo dataVo){
        System.out.println(JSONObject.toJSONString(dataVo));
        Map<String, Object> result = new HashMap<String, Object>();
        if(dataVo.getNum() == null || StringUtils.isBlank(dataVo.getId())){
            result.put("msg", "参数不合法！");
        }else {
            result.put("msg","参数合法");
        }
        //xxx业务逻辑处理
        return result;
    }


    @RequestMapping("/add02")
    @ResponseBody//此处不能省略 否则ajax无法解析返回值
    public Map<String,Object> add02(@RequestBody DataVo dataVo){//@RequestBody注解不能省略，否则无法接值
        Map<String,Object> resultMap = new HashMap<String, Object>();
        //业务逻辑处理
        resultMap.put("key","成功");
        return resultMap;
    }
}
