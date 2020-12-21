package com.money.utils.impl;

import com.money.utils.Jwt;
import com.money.bo.Token;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.UUID;

/**
 * @version V1.0
 * @Package com.money.utils.impl
 * @ClassName JwtImpl
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:46
 **/
@Component
public class JwtImpl implements Jwt {

    private Logger log = LoggerFactory.getLogger(JwtImpl.class);
    //Token默认1个小时内有效
    public  long accessTokenExpirationTime = 60 * 60 * 1;

    @Override
    public String createToken(Object account, String keyId, String privateKeyStr) throws Exception {

        log.error(account.toString());
        log.error(keyId);
        log.error(privateKeyStr);
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(accessTokenExpirationTime);
        claims.setExpirationTime(date);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public String createToken(Object account, String keyId, String privateKeyStr, long time)throws Exception{
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(time);
        claims.setExpirationTime(date);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public String createToken(String account, String SUBJECT, String keyId, String privateKeyStr)throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(accessTokenExpirationTime);
        claims.setExpirationTime(date);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setSubject(SUBJECT);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public String createToken(String account, String SUBJECT, String keyId, String privateKeyStr, long time) throws Exception{
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(time);
        claims.setExpirationTime(date);
        claims.setSubject(SUBJECT);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public String createToken(String account, String SUBJECT, String AUDIENCE, String keyId, String privateKeyStr) throws Exception{
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(accessTokenExpirationTime);
        claims.setExpirationTime(date);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setSubject(SUBJECT);
        claims.setAudience(AUDIENCE);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public String createToken(String account, String SUBJECT, String AUDIENCE, String keyId, String privateKeyStr, long time)throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setGeneratedJwtId();
        claims.setIssuedAtToNow();
        NumericDate date = NumericDate.now();
        date.addSeconds(time);
        claims.setExpirationTime(date);
        claims.setNotBeforeMinutesInThePast(1);
        claims.setSubject(SUBJECT);
        claims.setAudience(AUDIENCE);
        claims.setClaim("account", account);
        return this.createToken(claims, keyId, privateKeyStr);
    }

    @Override
    public boolean verifyTokenBoolean(String token, String publicKeyStr) throws Exception{
        JwtConsumer consumer = new JwtConsumerBuilder()
                .setRequireExpirationTime()
                .setMaxFutureValidityInMinutes(5256000)
                .setAllowedClockSkewInSeconds(30)
                //.setExpectedIssuer("")
                //如果未设置此值  校验的时候也布恩那个设置这个值
               // .setRequireSubject()
                //.setExpectedAudience()
                .setVerificationKey(new RsaJsonWebKey(JsonUtil.parseJson(publicKeyStr)).getPublicKey())
                .build();
        JwtClaims claims = consumer.processToClaims(token);

        log.error(claims.toString());
        if (claims != null||!claims.equals("") ) {
            String account = (String) claims.getClaimValue("account");
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean verifyTokenBoolean(String token, String publicKeyStr, String SUBJECT) throws Exception {
        return false;
    }

    @Override
    public boolean verifyTokenBoolean(String token, String publicKeyStr, String SUBJECT, String AUDIENCE) throws Exception {
        return false;
    }

    @Override
    public Object verifyTokenObject(String token, String publicKeyStr) throws Exception{
        return null;
    }

    @Override
    public Token createKeyPair() throws Exception{
        String keyId = UUID.randomUUID().toString().replaceAll("-", "");
        RsaJsonWebKey jwk = null;
        try {
            jwk = RsaJwkGenerator.generateJwk(2048);
        } catch (JoseException e) {
            e.printStackTrace();
        }
        jwk.setKeyId(keyId);
        //采用的签名算法 RS256
        jwk.setAlgorithm(AlgorithmIdentifiers.RSA_USING_SHA256);
        String publicKeyStr = jwk.toJson(RsaJsonWebKey.OutputControlLevel.PUBLIC_ONLY);
        String privateKeyStr = jwk.toJson(RsaJsonWebKey.OutputControlLevel.INCLUDE_PRIVATE);
        return  new Token(publicKeyStr,privateKeyStr,keyId);
    }

    private String createToken( JwtClaims claims,String keyId,String privateKeyStr) throws Exception {
        //jws
        JsonWebSignature jws = new JsonWebSignature();
        //签名算法RS256
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setKeyIdHeaderValue(keyId);
        jws.setPayload(claims.toJson());
        PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
        System.out.println(privateKey);
        jws.setKey(privateKey);
        //get token
        String idToken = jws.getCompactSerialization();
        return idToken;
    }


}
