package com.eat.ao;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.eat.ao
 * @ClassName loginAo
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/19 0:10
 **/
public class loginAo implements Serializable {
    private static final long serialVersionUID = 5700190824562325656L;

    private String phone;
    private String code;
    //修改密码专用
    private String old_Phone;
    private String new_phone;
    private String pwd;



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

    public String getOld_Phone() {
        return old_Phone;
    }

    public void setOld_Phone(String old_Phone) {
        this.old_Phone = old_Phone;
    }

    public String getNew_phone() {
        return new_phone;
    }

    public void setNew_phone(String new_phone) {
        this.new_phone = new_phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
