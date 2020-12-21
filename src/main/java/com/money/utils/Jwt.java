package com.money.utils;

import com.money.bo.Token;
import org.apache.logging.log4j.util.StringMap;

/**
 * @version V1.0
 * @Package com.money.utils
 * @ClassName Jwt
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:44
 **/
public interface Jwt {

    String createToken(Object account,String keyId,String privateKeyStr) throws Exception;
    //
    String createToken(Object account,String keyId,String privateKeyStr,long time) throws Exception;
    //
    String createToken(String account,String SUBJECT,String keyId,String privateKeyStr) throws Exception;
    String createToken(String account,String SUBJECT,String keyId,String privateKeyStr,long time) throws Exception;
    //
    String createToken(String account,String SUBJECT,String AUDIENCE,String keyId,String privateKeyStr) throws Exception;
    String createToken(String account,String SUBJECT,String AUDIENCE,String keyId,String privateKeyStr,long time) throws Exception;
    //
    boolean verifyTokenBoolean(String token,String publicKeyStr) throws Exception;
    boolean verifyTokenBoolean(String token, String publicKeyStr, String SUBJECT) throws Exception;
    boolean verifyTokenBoolean(String token,String publicKeyStr, String SUBJECT,String AUDIENCE) throws Exception;
    Object verifyTokenObject(String token,String publicKeyStr) throws Exception;
    Token createKeyPair() throws Exception;

}
