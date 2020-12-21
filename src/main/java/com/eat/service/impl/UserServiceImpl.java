package com.eat.service.impl;

import com.eat.ao.loginAo;
import com.eat.comom.MsgConst;
import com.eat.comom.RspMsg;
import com.eat.dao.UserMapper;
import com.eat.entity.User;
import com.eat.service.UserService;
import com.eat.util.interfaces.JWT;
import com.eat.util.interfaces.Redis;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/14 23:49
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    private JWT jwt;

    @Autowired
    private Redis redis;

    @Override
    public RspMsg CreateUser(User user) {
      int s = this.userMapper.addUser(user);
      if(s!=1){
          return  RspMsg.createRspMsg(MsgConst.CODE_CREAT_USER_IS_INVALID, MsgConst.MSG_CODE_CREAT_USER_IS_INVALID);
      }
        return RspMsg.Success();
    }

    @Override
    public RspMsg SelectUser(User user) {
        if(user==null){
            return  RspMsg.createRspMsg(MsgConst.CODE_VAR_NOT_NULL, MsgConst.MSG_CODE_VAR_NOT_NULL);
        }
        List<User> list = this.userMapper.SelectUserByUser(user);
        return RspMsg.Success(list);
    }

    @Override
    public User SelectUserByUserName(String UserPhone) {
        if(StringUtils.isEmpty(UserPhone)){
            return  null;
        }
        List<User> list = this.userMapper.SelectUserByUser(new User(UserPhone));
        if(list.size()!=1){
            return null;
        }
        return list.get(0);
    }

    @Override
    public RspMsg Login(loginAo loginao) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginao.getPhone(),loginao.getPwd());
        subject.login(usernamePasswordToken);
        User userSecret  = jwt.createKeyPair();
        System.out.println(userSecret.toString());
        //TODO 生成TOKEN
        String token = jwt.createToken(loginao.getPhone(), userSecret.getKeyId(),userSecret.getPrivateKeyStr());
        if(token==null){
            return RspMsg.createRspMsg(MsgConst.CODE_CREAT_TOKEN_IS_INVALID,MsgConst.MSG_CODE_CREAT_TOKEN_IS_INVALID);
        }
        //TODO 将加密信息储存到数据库
        userSecret.setUser_phone(loginao.getPhone());
        int count = userMapper.UpdateUserByPhone(userSecret);
        if(count != 1 ) {
            return RspMsg.createRspMsg(MsgConst.CODE_SQL_ADD_TOKEN_IS_INVALID, MsgConst.MSG_CODE_SQL_ADD_TOKEN_IS_INVALID);
        }
        //TODO 将密钥缓存进
        Boolean bol = redis.set(token, userSecret.getPublicKeyStr());
        if(!bol){
            return RspMsg.createRspMsg(MsgConst.CODE_REDIS_ADD_TOKEN_IS_INVALID, MsgConst.MSG_CODE_REDIS_ADD_TOKEN_IS_INVALID);
        }
        return RspMsg.Success(token);
    }

    @Override
    public RspMsg UpdateUserPhone(loginAo loginAo) {
        return null;
    }

    @Override
    public RspMsg UpdateUserByPhone(User user) {
        return null;
    }


}
