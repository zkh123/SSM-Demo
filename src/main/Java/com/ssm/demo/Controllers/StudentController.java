package com.ssm.demo.Controllers;

import com.ssm.demo.Entity.Student;
import com.ssm.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/get")
    public String Get() {
        List<Student> students = studentService.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        return jsonResult;
    }
}
