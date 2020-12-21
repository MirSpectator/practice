package com.eat.util.interfaces;

import com.eat.entity.User;
import org.jose4j.lang.JoseException;

/**
 * @version V1.0
 * @Package com.eat.comom.util
 * @ClassName JWT
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/9 19:22
 **/
public interface JWT {
    //
    String createToken(Object account,String keyId,String privateKeyStr);
    //
    String createToken(String account,String SUBJECT,String keyId,String privateKeyStr);
    //
    String createToken(String account,String SUBJECT,String AUDIENCE,String keyId,String privateKeyStr);
    //
    boolean verifyTokenBoolean(String token,String publicKeyStr);
    Object verifyTokenObject(String token,String publicKeyStr);
    User createKeyPair() ;
}
