package com.omney.query;

import org.springframework.stereotype.Service;
import reactor.util.annotation.NonNull;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.omney.query
 * @ClassName Login
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:39
 **/
public class Login implements Serializable {
    private static final long serialVersionUID = 5147549140689686541L;

    private String phone;
    private String code;

    private String number;
    private String pwd;

    @NonNull
    private int type;

    public Login() {
    }

    public Login(String phone, String code, String number, String pwd, int type) {
        this.phone = phone;
        this.code = code;
        this.number = number;
        this.pwd = pwd;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Login{" +
                "phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", number='" + number + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type=" + type +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
