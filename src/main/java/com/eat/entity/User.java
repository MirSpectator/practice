package com.eat.entity;



import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.security.PublicKey;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName user
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/14 22:35
 **/
public class User implements Serializable {
    private static final long serialVersionUID = 8196270106098984046L;
    private Integer id;
    private String user_name;
    private String user_phone;
    private String user_img;
    private String keyId;
    private String publicKeyStr;
    private String privateKeyStr;
    private String user_pwd;

    private String code;

    public User(){

    };

    public User(String user_phone) {
        this.user_phone = user_phone;
    }

    public User(String keyId, String publicKeyStr, String privateKeyStr) {
        this.keyId = keyId;
        this.publicKeyStr = publicKeyStr;
        this.privateKeyStr = privateKeyStr;
    }

    public User(Integer id, String user_name, String user_phone, String user_img, String keyId, String publicKeyStr, String privateKeyStr, String user_ped) {
        this.id = id;
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_img = user_img;
        this.keyId = keyId;
        this.publicKeyStr = publicKeyStr;
        this.privateKeyStr = privateKeyStr;
        this.user_pwd = user_ped;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_ped) {
        this.user_pwd = user_ped;
    }


    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getPublicKeyStr() {
        return publicKeyStr;
    }

    public void setPublicKeyStr(String publicKeyStr) {
        this.publicKeyStr = publicKeyStr;
    }

    public String getPrivateKeyStr() {
        return privateKeyStr;
    }

    public void setPrivateKeyStr(String privateKeyStr) {
        this.privateKeyStr = privateKeyStr;
    }
}
