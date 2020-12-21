package com.eat.util;



import com.eat.entity.User;
import com.eat.service.UserService;
import com.eat.util.interfaces.JWT;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.UUID;

/**
 * @version V1.0
 * @Package com.eat.comom.util
 * @ClassName JWTUtils
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/19 22:40
 **/
@Component
public class JWTUtils implements JWT {

    @Autowired
    private UserService userService;

    /**
     * keyId,公钥,私钥 都是用 createKeyPair 方法生成
     */

    public  long accessTokenExpirationTime = 60 * 60 * 24;

    //jws创建token
    public String createToken(Object account,String keyId,String privateKeyStr) {
        try {
            //Payload
            JwtClaims claims = new JwtClaims();
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //expire time
            NumericDate date = NumericDate.now();
            date.addSeconds(accessTokenExpirationTime);
            claims.setExpirationTime(date);
            claims.setNotBeforeMinutesInThePast(1);
            claims.setSubject("YOUR_SUBJECT");
            claims.setAudience("YOUR_AUDIENCE");
            //添加自定义参数,必须是字符串类型
            claims.setClaim("account", account);

            //jws
            JsonWebSignature jws = new JsonWebSignature();
            //签名算法RS256
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            jws.setKeyIdHeaderValue(keyId);
            jws.setPayload(claims.toJson());
            /*
            RsaJsonWebKey jwk = null;
            try {
                jwk = RsaJwkGenerator.generateJwk(2048);
                } catch (JoseException e) {
                    e.printStackTrace();
                }
                jwk.setKeyId(keyId); */
            //PrivateKey privateKey = jwk.getPrivateKey();
            System.out.println("创建"+privateKeyStr);
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
            System.out.println(privateKey);
            jws.setKey(privateKey);

            //get token
            String idToken = jws.getCompactSerialization();
            return idToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //jws创建token
    public String createToken(String account,String SUBJECT,String keyId,String privateKeyStr) {
        //调用方法生成keyId,公钥,私钥
        try {
            //Payload
            JwtClaims claims = new JwtClaims();
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //expire time
            NumericDate date = NumericDate.now();
            date.addSeconds(accessTokenExpirationTime);
            claims.setExpirationTime(date);
            claims.setNotBeforeMinutesInThePast(1);
            claims.setSubject(SUBJECT);
            claims.setAudience("YOUR_AUDIENCE");
            //添加自定义参数,必须是字符串类型
            claims.setClaim("account", account);

            //jws
            JsonWebSignature jws = new JsonWebSignature();
            //签名算法RS256
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            jws.setKeyIdHeaderValue(keyId);
            jws.setPayload(claims.toJson());
            /*
            RsaJsonWebKey jwk = null;
            try {
                jwk = RsaJwkGenerator.generateJwk(2048);
                } catch (JoseException e) {
                    e.printStackTrace();
                }
                jwk.setKeyId(keyId); */
            //PrivateKey privateKey = jwk.getPrivateKey();
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
            jws.setKey(privateKey);

            //get token
            String idToken = jws.getCompactSerialization();
            return idToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //jws创建token
    public String createToken(String account,String SUBJECT,String AUDIENCE,String keyId,String privateKeyStr) {
        //调用方法生成keyId,公钥,私钥
        try {
            //Payload
            JwtClaims claims = new JwtClaims();
            claims.setGeneratedJwtId();
            claims.setIssuedAtToNow();
            //expire time
            NumericDate date = NumericDate.now();
            date.addSeconds(accessTokenExpirationTime);
            claims.setExpirationTime(date);
            claims.setNotBeforeMinutesInThePast(1);
            claims.setSubject(SUBJECT);
            claims.setAudience(AUDIENCE);
            //添加自定义参数,必须是字符串类型
            claims.setClaim("account", account);

            //jws
            JsonWebSignature jws = new JsonWebSignature();
            //签名算法RS256
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
            jws.setKeyIdHeaderValue(keyId);
            jws.setPayload(claims.toJson());
            /*
            RsaJsonWebKey jwk = null;
            try {
                jwk = RsaJwkGenerator.generateJwk(2048);
                } catch (JoseException e) {
                    e.printStackTrace();
                }
                jwk.setKeyId(keyId); */
            //PrivateKey privateKey = jwk.getPrivateKey();
            PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
            jws.setKey(privateKey);

            //get token
            String idToken = jws.getCompactSerialization();
            return idToken;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * jws校验token
     *
     * @param token
     * @return 返回 用户账号
     * @throws JoseException
     */
    public boolean verifyTokenBoolean(String token,String publicKeyStr) {
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setMaxFutureValidityInMinutes(5256000)
                    .setAllowedClockSkewInSeconds(30)
                    .setRequireSubject()
                    //.setExpectedIssuer("")
                    .setExpectedAudience("YOUR_AUDIENCE")
                    /*
                    RsaJsonWebKey jwk = null;
                    try {
                        jwk = RsaJwkGenerator.generateJwk(2048);
                        } catch (JoseException e) {
                            e.printStackTrace();
                        }
                        jwk.setKeyId(keyId); */
                    //.setVerificationKey(jwk.getPublicKey())
                    .setVerificationKey(new RsaJsonWebKey(JsonUtil.parseJson(publicKeyStr)).getPublicKey())
                    .build();
            //System.out.println("11111111111111111111111");
            JwtClaims claims = consumer.processToClaims(token);
           // System.out.println("~~~~~~~~~~~~~~~~~~~"+claims);
            if (claims != null||!claims.equals("") ) {
                //System.out.println("认证通过！");
                //System.out.println(claims);
                String account = (String) claims.getClaimValue("account");
                //System.out.println("token payload携带的自定义内容:用户账号account=" + account);
                return true;
            }else {
                //System.out.println("认证失败！");

                return false;
            }
        }  catch (JoseException e) {
            e.printStackTrace();
        }  catch (InvalidJwtException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Object verifyTokenObject(String token,String publicKeyStr){
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setMaxFutureValidityInMinutes(5256000)
                    .setAllowedClockSkewInSeconds(30)
                    .setRequireSubject()
                    //.setExpectedIssuer("")
                    .setExpectedAudience("YOUR_AUDIENCE")
                    /*
                    RsaJsonWebKey jwk = null;
                    try {
                        jwk = RsaJwkGenerator.generateJwk(2048);
                        } catch (JoseException e) {
                            e.printStackTrace();
                        }
                        jwk.setKeyId(keyId); */
                    //.setVerificationKey(jwk.getPublicKey())
                    .setVerificationKey(new RsaJsonWebKey(JsonUtil.parseJson(publicKeyStr)).getPublicKey())
                    .build();
            System.out.println(publicKeyStr);
            //System.out.println("11111111111111111111111");
            JwtClaims claims = consumer.processToClaims(token);
            // System.out.println("~~~~~~~~~~~~~~~~~~~"+claims);
            if (claims != null||!claims.equals("") ) {
                //System.out.println("认证通过！");
                //System.out.println(claims);
                Object account =  claims.getClaimValue("account");
                //System.out.println("token payload携带的自定义内容:用户账号account=" + account);
                return account;
            }else {
                //System.out.println("认证失败！");

                return null;
            }
        }  catch (JoseException e) {
            e.printStackTrace();
        }  catch (InvalidJwtException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 创建jwk keyId , 公钥 ，秘钥
     */
    public User createKeyPair() {
        /**
         * UUID.randomUUID().toString()是javaJDK提供的一个自动生成主键的方法。
         * UUID(Universally Unique Identifier)全局唯一标识符,
         * 是指在一台机器上生成的数字，它保证对在同一时空中的所有机器都是唯一的，
         * 是由一个十六位的数字组成,表现出来的 形式。由以下几部分的组合：
         * 当前日期和时间(UUID的第一个部分与时间有关，
         * 如果你在生成一个UUID之后，过几秒又生成一个UUID，
         * 则第一个部分不 同，其余相同)，时钟序列，全局唯一的IEEE机器识别号
         * （如果有网卡，从网卡获得，没有网卡以其他方式获得），
         * UUID的唯一缺陷在于生成的结果串会比较长。
         * UUID是由一个十六位的数字组成,表现出来的形式例如 550E8400-E29B-11D4-A716-446655440000
         * String uid = UUID.randomUUID().toString().substring(0,5)；
         * //六位UUID
         * //bf7c30
         */
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
       /* PrivateKey privateKeys = new RsaJsonWebKey(JsonUtil.parseJson(privateKeyStr)).getPrivateKey();
        System.out.println("123");
        System.out.println(privateKeys);
        PrivateKey privateKey = jwk.getPrivateKey();
        PublicKey publicKey = jwk.getPublicKey();
        System.out.println("keyId="+keyId);
        System.out.println();
        System.out.println("公钥 publicKeyStr="+publicKey.toString());
        System.out.println(publicKeyStr);
        System.out.println();
        System.out.println("私钥 privateKeyStr="+privateKey.toString());
        System.out.println(privateKeyStr);*/
        return  new User(keyId,publicKeyStr,privateKeyStr);
    }
  /*  public static void main(String[] args) throws JoseException {
         *//* JWTUtils s = new JWTUtils();
        s.createKeyPair();
      System.out.println("------------");
        String a = s.createToken("你好啊，王振鹏");
        System.out.println(a);
        System.out.println("------------2");
        String b = s.verifyToken(a);
        System.out.println(b);
        System.out.println("============================");*//*

        JWTUtils s = new JWTUtils();
        User user = s.createKeyPair();

        PrivateKey privateKey = new RsaJsonWebKey(JsonUtil.parseJson(user.getPrivateKeyStr())).getPrivateKey();
        System.out.println(privateKey);
        //System.out.println(s.verifyToken("eyJhbGciOiJSUzI1NiIsImtpZCI6ImZhNjc3ZDUyNWMwZTRlZTQ4NWE2MTU0MzkzNzc5NGFmIn0.eyJqdGkiOiJyc3A0UEEybFZRSUNEb1VEWlVXVU1BIiwiaWF0IjoxNjAzMjA5NzMzLCJleHAiOjE2MDMyOTYxMzMsIm5iZiI6MTYwMzIwOTY3Mywic3ViIjoiWU9VUl9TVUJKRUNUIiwiYXVkIjoiWU9VUl9BVURJRU5DRSIsImFjY291bnQiOiLkvaDlpb3llYrvvIznjovmjK_puY8ifQ.KueqUX6FeYJ-WNotAZh9nvyeb0xjLfYPNbmQR2CbJYaiOuBkeI65Fc53n_FDfJINY3NVUNIkBAb5M4zvzPdORIhsceI3nef0-vfuH6CC-9w1bZqtY9qZ42FUSDgBocZlsLZDFM5jLr2WR3gPCZg7urhdGZNwfkBhGB3gYvUbntOLcWBqpRSqtfVqMPXGSxGx671CaELCO58Bgxl5QSjWi-yhbjcUS9SV4oD248DKtIemBLFV5YhE7uEqxCIFlqXLcIVCTFuQmv9DEmZidSk0cDYuYAPMEc8cVSxZmvb8nZlRwfWgBsj-E-5v3F6ofY9BBxaPesQcLQ_onxZBZ3IS_w1"));
    }*/
}
