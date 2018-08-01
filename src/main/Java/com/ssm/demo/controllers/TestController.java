package com.ssm.demo.controllers;

import com.alibaba.fastjson.JSONObject;
import com.ssm.demo.entity.Test;
import com.ssm.demo.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class TestController {
    public static Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping(value = "/test")
    public String toTestPage(){
        return "test";
    }

    /**
     * 页面ajax提交一个对象
     * @param username
     * @param password
     * @param email
     * @param phone
     * @return
     */
    @RequestMapping(value = "/first",method = RequestMethod.POST)
    @ResponseBody//此注解不能省略 否则ajax无法接受返回值
    public Map<String,Object> first(@RequestParam(value = "username")String username,
                                     @RequestParam(value = "password")String password,
                                     @RequestParam(value = "email")String email,
                                     @RequestParam(value = "phone")String phone){
        logger.info("username = " + username + " password = " + password + " email = " + email + " phone = " + phone);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(email) || StringUtils.isBlank(phone)){
            resultMap.put("message", "参数不合法！");
            return resultMap;
        }
        resultMap.put("message", "SUCCESS");
        return resultMap;
    }


    /**
     * 页面ajax提交一个对象
     * @param test
     * @return
     */
    @RequestMapping(value = "/second",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> second(Test test){
        logger.info(JSONObject.toJSONString(test));
        Map<String, Object> result = new HashMap<String, Object>();
        if(test.getUsername() == null || StringUtils.isBlank(test.getPassword())){
            result.put("message", "参数不合法！");
        }else {
            result.put("message","SUCCESS");
        }
        return result;
    }


    @RequestMapping(value = "/three",method = RequestMethod.POST)
    @ResponseBody//此处不能省略 否则ajax无法解析返回值
    public Map<String,Object> three(@RequestBody Test test){//@RequestBody注解不能省略，否则无法接值
        logger.info(JSONObject.toJSONString(test));
        Map<String, Object> result = new HashMap<String, Object>();
        if(test.getUsername() == null || StringUtils.isBlank(test.getPassword())){
            result.put("message", "参数不合法！");
        }else {
            result.put("message","SUCCESS");
        }
        return result;
    }

    @RequestMapping(value = "/four",method = RequestMethod.POST)
    @ResponseBody//此处不能省略 否则ajax无法解析返回值
    public Map<String,Object> four(@RequestBody List<Test> tests){//@RequestBody注解不能省略，否则无法接值
        logger.info(JSONObject.toJSONString(tests));
        Map<String, Object> result = new HashMap<String, Object>();
        if(tests == null || tests.size() == 0){
            result.put("message", "参数不合法！");
        }else {
            result.put("message","SUCCESS");
        }
        return result;
    }

    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public String  springUpload(@RequestParam("file") CommonsMultipartFile file,
                                HttpServletRequest request) throws IllegalStateException, IOException{
        long  startTime=System.currentTimeMillis();
        // 获得原始文件名
        String fileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = UUID.randomUUID() + fileName;
        ServletContext sc = request.getSession().getServletContext();
        // 上传位置
        String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        if (!file.isEmpty()) {
            //保存文件
            try {
                FileOutputStream fos = new FileOutputStream(path + newFileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //读取文件的内容
            InputStream inputStream = file.getInputStream();
            byte[] buf = new byte[1024];
            StringBuffer sb = new StringBuffer();
            try {
                while (inputStream.read(buf) != -1) {
                    sb.append(new String(buf, "UTF-8"));
                }
                System.out.println(sb);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "redirect:test";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject login(@RequestBody User user){
        System.out.println(JSONObject.toJSONString(user));
        JSONObject param = new JSONObject();
        param.put("flag","login success");
        return param;
    }
}
