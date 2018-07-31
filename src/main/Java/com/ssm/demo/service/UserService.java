package com.ssm.demo.service;

import com.ssm.demo.dao.UserMapper;
import com.ssm.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserByName(User user) {
        return userMapper.findUserByName(user);
    }

    public User findUserByNameAndPwd(User user) {
        return userMapper.findUserByNameAndPwd(user);
    }

    public List<User> findUserList() throws Exception {
        return userMapper.findUserList();
    }

    public int addUser(User user) throws Exception {
        return userMapper.addUser(user);
    }

    public int updateUserByUserName(User user) throws Exception {
        return userMapper.updateUserByUserName(user);
    }

    public int deleteUserById(int id) throws Exception {
        return userMapper.deleteUserById(id);
    }

    public List<String> getRolesByUsername(String username) {
        return userMapper.getRolesByUsername(username);
    }

    public User getPasswordByUsername(String username) {
        return userMapper.getPasswordByUsername(username);
    }

    public List<String> getPermisionByUsername(String username) {
        return userMapper.getPermisionByUsername(username);
    }
}
