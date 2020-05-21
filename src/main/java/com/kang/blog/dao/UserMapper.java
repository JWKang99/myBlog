package com.kang.blog.dao;

import com.kang.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//Mapper是Mybatis的注解,
//Repository用于声明dao层的bean
@Mapper
@Repository
public interface UserMapper {

    //验证用户名密码
    User findByUsernameAndPassword(String username,String password);

}
