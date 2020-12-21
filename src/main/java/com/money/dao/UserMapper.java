package com.money.dao;

import com.money.entity.User;
import reactor.util.annotation.NonNull;

import java.util.List;

/**
 * @version V1.0
 * @Package com.money.dao
 * @ClassName UserMapper
 * @Description TODO 用户表
 * @Author 王振鹏
 * @date 2020/12/20 21:56
 **/
public interface UserMapper {

     //查询用户
     List<User> listObjects();

     //通过手机号查询
     User getUserByPhone(@NonNull String Phone);



}
