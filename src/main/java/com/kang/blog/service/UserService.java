package com.kang.blog.service;

import com.kang.blog.entity.User;

public interface UserService {
    User checkUser(String username,String password);
}
