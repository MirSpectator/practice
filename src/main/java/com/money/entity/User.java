package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName User
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 21:40
 **/
public class User implements Serializable {
    private static final long serialVersionUID = -5183076979091357718L;

    private String phone;
    private String name;
    private int age;
    private String sex;
    private String pwd;
    private String head_img;
    private int pay_pwd;
    private String authentication_type;
    private String id_card;
    private Date create_time;
    private Date update_time;

    public User() {
    }

    public User(String phone, String name, int age, String sex, String pwd, String head_img, int pay_pwd, String authentication_type, String id_card, Date create_time, Date update_time) {
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pwd = pwd;
        this.head_img = head_img;
        this.pay_pwd = pay_pwd;
        this.authentication_type = authentication_type;
        this.id_card = id_card;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                ", head_img='" + head_img + '\'' +
                ", pay_pwd=" + pay_pwd +
                ", authentication_type='" + authentication_type + '\'' +
                ", id_card='" + id_card + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public int getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(int pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public String getAuthentication_type() {
        return authentication_type;
    }

    public void setAuthentication_type(String authentication_type) {
        this.authentication_type = authentication_type;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
