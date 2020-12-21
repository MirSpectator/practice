package com.money.bo;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.moneybo
 * @ClassName Token
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:48
 **/
public class Token implements Serializable {
    private static final long serialVersionUID = -2309079010356410931L;

    private String publicKeyStr;
    private String privateKeyStr;
    private String keyId;

    public Token(String publicKeyStr, String privateKeyStr, String keyId) {
        this.publicKeyStr = publicKeyStr;
        this.privateKeyStr = privateKeyStr;
        this.keyId = keyId;
    }

    @Override
    public String toString() {
        return "Token{" +
                "publicKeyStr='" + publicKeyStr + '\'' +
                ", privateKeyStr='" + privateKeyStr + '\'' +
                ", keyId='" + keyId + '\'' +
                '}';
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

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}
