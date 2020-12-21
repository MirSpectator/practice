package com.money.server;

import com.money.comom.RspMsg;
import com.omney.query.Login;
import reactor.util.annotation.NonNull;

/**
 * @version V1.0
 * @Package com.money.server
 * @ClassName in
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:24
 **/
public interface UserServer {

    RspMsg listObjects() throws Exception;

    RspMsg getUserByPhone(@NonNull String phone) throws Exception;

    RspMsg Login(Login login) throws Exception;

}
