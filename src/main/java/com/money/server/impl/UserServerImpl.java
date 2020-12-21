package com.money.server.impl;

import com.money.bo.Token;
import com.money.comom.RspMsg;
import com.money.dao.UserMapper;
import com.money.entity.User;
import com.money.server.UserServer;
import com.money.utils.Jwt;
import com.money.utils.impl.CacheUtil;
import com.omney.query.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.util.annotation.NonNull;

import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.List;

/**
 * @version V1.0
 * @Package com.money.server.impl
 * @ClassName UserServerImpl
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:28
 **/
@Service
public class UserServerImpl implements UserServer {

    private Logger log = LoggerFactory.getLogger(UserServerImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Jwt jwt;

    @Override
    public RspMsg listObjects() throws Exception{

        List<User>  list = this.userMapper.listObjects();

        if(list.size()<0){
            return RspMsg.crmoneyeRspMsg("0000", "测试数据库查询失败");
        }

        return RspMsg.Success(list);
    }

    @Override
    public RspMsg getUserByPhone(String phone) throws Exception{

        User user = this.userMapper.getUserByPhone(phone);

        if(user==null){
            return RspMsg.crmoneyeRspMsg("0000", "测试数据库查询失败");
        }

        return RspMsg.Success(user);
    }


    @Override
    public RspMsg Login(Login login) throws Exception{
        User user =this.userMapper.getUserByPhone(login.getPhone());
        log.info("type-------"+login.getType());
        //验证密码的方式
        if(login.getType()==0){

        }else {

        }
        if(user==null)
            return RspMsg.crmoneyeRspMeg("没有此用户");
        Token token = this.jwt.createKeyPair();
        String tokens = this.jwt.createToken(user, token.getKeyId(), token.getPrivateKeyStr());
        CacheUtil.put(tokens, token.getPublicKeyStr());
        return RspMsg.Success(tokens);
    }
}
