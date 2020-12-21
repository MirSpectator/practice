package com.eat.service;

import com.eat.ao.loginAo;
import com.eat.comom.RspMsg;
import com.eat.entity.User;
import org.jose4j.lang.JoseException;

/**
 * @version V1.0
 * @Package com.eat.service
 * @ClassName UserService
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/14 23:48
 **/
public interface UserService {
    // TODO 注册的用户
    RspMsg CreateUser(User user);
    // TODO 查询用户，验证密码 ，用过实体类
    RspMsg SelectUser(User user);
    // TODO 查询用户，通过用户的名称查询用户
    User SelectUserByUserName(String UserPhone);
    // TODO 登录方法
    RspMsg Login(loginAo loginAo) ;
    // TODO 修改用户的手机号
    RspMsg UpdateUserPhone(loginAo loginAo);
    // TODO 修改用户的个人信息
    RspMsg UpdateUserByPhone(User user);

}
