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

    private int id;
    private String name;
    private String number;
    private int age;
    private String sex;
    private String pwd;
    private String phone;
    private String head_img;
    private String identity;
    private int autonym;
    private int pay_pwd;
    private Date creat_time;

    public User() {
    }

    public User(int id, String name, String number, int age, String sex, String pwd, String phone, String head_img, String identity, int autonym, int pay_pwd, Date creat_time) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.age = age;
        this.sex = sex;
        this.pwd = pwd;
        this.phone = phone;
        this.head_img = head_img;
        this.identity = identity;
        this.autonym = autonym;
        this.pay_pwd = pay_pwd;
        this.creat_time = creat_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", head_img='" + head_img + '\'' +
                ", identity='" + identity + '\'' +
                ", autonym=" + autonym +
                ", pay_pwd=" + pay_pwd +
                ", creat_time=" + creat_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAutonym() {
        return autonym;
    }

    public void setAutonym(int autonym) {
        this.autonym = autonym;
    }

    public int getPay_pwd() {
        return pay_pwd;
    }

    public void setPay_pwd(int pay_pwd) {
        this.pay_pwd = pay_pwd;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }
}
