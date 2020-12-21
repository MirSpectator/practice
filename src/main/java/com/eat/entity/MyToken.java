package com.eat.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName Token
 * @Description 自定义Token类
 * @Author 王振鹏
 * @date 2020/10/26 21:47
 **/
public class MyToken implements AuthenticationToken {

    private String Token;

    public MyToken(String token){
        System.out.println("tokern------------------------");
        System.out.println(token);
        this.Token = token;
    }

    @Override
    public  String getPrincipal() {
        return Token;
    }

    @Override
    public Object getCredentials() {
        return Token;
    }
}
