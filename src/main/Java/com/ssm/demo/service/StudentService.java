package com.ssm.demo.service;

import com.ssm.demo.dao.StudentMapper;
import com.ssm.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{
    @Autowired
    private StudentMapper studentMapper;

    public int deleteByPrimaryKey(byte[] uid) {
        return studentMapper.deleteByPrimaryKey(uid);
    }

    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    public Student selectByPrimaryKey(byte[] uid) {
        return studentMapper.selectByPrimaryKey(uid);
    }

    public List<Student> selectByCondition(Student record) {
        return studentMapper.selectByCondition(record);
    }

    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
