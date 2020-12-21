package com.eat.config;

import com.alibaba.fastjson.JSONObject;
import com.eat.util.interfaces.JWT;
import com.eat.entity.User;
import com.eat.service.UserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @version V1.0
 * @Package com.eat.config
 * @ClassName MyCredentialsMatcher
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/23 23:49
 **/
public class MyCredentialsMatcher implements CredentialsMatcher {


    @Autowired
    private UserService userService;

    @Autowired
    private JWT jwt;


    /**
     * @Summary
     * @Param: [token, info]
     * @Return: boolean
     * @Author: TheRaging
     * @Date: 2020/10/23 23:49
     * @Description 密码校验器，在这里实现自定义的密码校验
     */
    //@Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        System.out.println("密码校验doCredentialsMatch------------------------------");
        //System.out.println("token------------"+token.getPrincipal());
        //System.out.println(token.getCredentials());
        //System.out.println("info---------------------"+info);
        /*User creatUser = JSONObject.parseObject(jwt.verifyTokenObject(token.getPrincipal().toString()).toString(),User.class);
        User user   = userService.SelectUserByUserName(creatUser.getUser_name());
        System.out.println(user.getUser_img());
        //System.out.println(user.toString());
        //System.out.println(creatUser.toString());
        if(user == null){
            System.out.println("没有此用户");
            return  false;
        }
        if(user.getUser_name().equals(creatUser.getUser_name()) && user.getOpenid().equals(creatUser.getOpenid())){
            System.out.println("登录成功");
            return true;
        }else{
            System.out.println("账号或密码不正确");
            return  false;
        }*/
        /*  UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(utoken.getPassword());
        String username = utoken.getUsername();
        //获得数据库中的密码
        String dbPassword = (String) info.getCredentials();
        SimpleAuthenticationInfo saInfo = (SimpleAuthenticationInfo)info;
        String salt = userService.findUserByName(username).getSalt();
        inPassword = CommunityUtil.md5(inPassword+salt);
        //进行密码的比对
        boolean flag = Objects.equals(inPassword, dbPassword);
        return flag;*/
        return false;
    }
}
