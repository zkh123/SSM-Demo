package com.ssm.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.ssm.demo.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    private RestTemplate restTemplate;

    public void doMaster(){
    }


    public JSONObject doException(){
        JSONObject jsonObject = new JSONObject();
        int a = 1/0;
        jsonObject.put("a",a);

        return jsonObject;

    }
}
