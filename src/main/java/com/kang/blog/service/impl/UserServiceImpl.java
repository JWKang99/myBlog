package com.kang.blog.service.impl;

import com.kang.blog.dao.UserMapper;
import com.kang.blog.entity.User;
import com.kang.blog.service.UserService;
import com.kang.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
