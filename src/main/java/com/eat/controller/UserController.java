package com.eat.controller;

import com.eat.ao.loginAo;
import com.eat.comom.GlobalException;
import com.eat.comom.RspMsg;

import com.eat.util.interfaces.JWT;
import com.eat.entity.User;
import com.eat.service.UserService;


import com.eat.util.interfaces.Redis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Package com.eat.controller
 * @ClassName test
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/13 23:57
 **/
@Controller
@ResponseBody
@RequestMapping("/test")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private  JWT jwt;

    @Autowired
    private Redis redis;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public  RspMsg Login(@RequestBody loginAo loginAo)  {

        //System.out.println(subject.getPrincipal());
        return userService.Login(loginAo);
    }


    @RequestMapping(value = "/CreateUser",method = {RequestMethod.POST})
    public  RspMsg CreateUser(@RequestBody User user){

        return  this.userService.CreateUser(user);
    }
    @GetMapping(value = "/two")
    public  String two(){
        log.info("123,日志输出成功");
      // log.info("你好啊");
       /* redis.set("1", 123);
        System.out.println(redis.get("1"));
        User user = new User();
        user.setUser_name("测试数据");
        user.setUser_phone("17637945521");
        redis.hset("123", "123", user);
        System.out.println(redis.hget("123", "123").getClass());
        System.out.println(((User)redis.hget("123", "123")).getUser_name());
        redis.set("456", user);
        System.out.println(redis.get("456"));*/
       /*String token =  jwt.createToken("123");
        System.out.println(token);
       String accout = (String) jwt.verifyTokenObject(token);*/
        throw  new GlobalException("参数一场");

    }
}
