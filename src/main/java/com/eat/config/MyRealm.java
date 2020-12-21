package com.eat.config;

import com.alibaba.fastjson.JSONObject;
import com.eat.entity.User;
import com.eat.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @version V1.0
 * @Package com.eat.config
 * @ClassName MyRealm
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/23 23:10
 **/
@Configuration
public class MyRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;


    /**
     * @Summary
     * @Param: [principals]
     * @Return: org.apache.shiro.authz.AuthorizationInfo
     * @Author: TheRaging
     * @Date: 2020/10/23 23:13
     * @Description 授权方法，获取角色，权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("权限校验");
        return null;
    }

    /**
     * @Summary
     * @Param: [token]
     * @Return: org.apache.shiro.authc.AuthenticationInfo
     * @Author: TheRaging
     * @Date: 2020/10/23 23:13
     * @Description 身份信息，获取账号信息，进行密码认证，
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("进入到登录方法doGetAuthenticationInfo---------------------------");
        //校验token是否为空
       if (StringUtils.isEmpty(token.getPrincipal().toString())) {
            return null;
        }

        System.out.println(token.getCredentials());
        System.out.println(token.getPrincipal());
        User user = userService.SelectUserByUserName(token.getPrincipal().toString());
        //获取用户信息
        if(user==null){
            return  null;
        }

            //这里验证authenticationToken和simpleAuthenticationInfo的信
            //SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,"密码",getName());
        //System.out.println(token.getPrincipal().toString());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,user.getUser_pwd(),getName());
            return simpleAuthenticationInfo;

    }

    /**
     * 此方法必须重写，只有重写了才可以使用自己的token
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        System.out.println("supports---------------------------------");
       // System.out.println(token);
        return   true;
    }

    /**
     * 如果需要用shiro缓存授权信息，每次请求都会走AuthorizingRealm中的getAuthorizationInfo方法，如果配置了使用了缓存，
     * 这两句代码（Object key = getAuthorizationCacheKey(principals); info = cache.get(key);）会首先从缓存
     * 中取授权信息，因为用了spring session，默认的取缓存的方法是得到之前登录成功的PrincipalCollection principals，
     * 但是因为每次都是从spring session表中去反序列化得到此对象，所以每次的对象都是新的，
     * 导致每次从缓存中取都取不到，现在重写此方法，将key改成每次登录后的登录名称，类型是String，这样cache.get(key)
     * 时，比较的是String的equals方法，则只要登录名称不变就能取到缓存中的值。
     *
     * @param principals 登录成功的凭证（user信息）
     * @return 从
     */
   /* @Override
    protected Object getAuthorizationCacheKey(PrincipalCollection principals) {
        User userInfo = (User) principals.getPrimaryPrincipal();
        System.out.println("getAuthorizationCacheKey===============================================");
        return userInfo.getid();
    }*/


}
