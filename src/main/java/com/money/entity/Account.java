package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName AccountLog
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 21:50
 **/
public class Account implements Serializable {
    private static final long serialVersionUID = -6049564307774430259L;

    private int account_id;
    private String phone;
    private String account_type;
    private Float account_money;
    private Date update_time;
    private Date create_time;

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", phone='" + phone + '\'' +
                ", account_type='" + account_type + '\'' +
                ", account_money=" + account_money +
                ", update_time=" + update_time +
                ", create_time=" + create_time +
                '}';
    }

    public Account() {
    }

    public Account(int account_id, String phone, String account_type, Float account_money, Date update_time, Date create_time) {
        this.account_id = account_id;
        this.phone = phone;
        this.account_type = account_type;
        this.account_money = account_money;
        this.update_time = update_time;
        this.create_time = create_time;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Float getAccount_money() {
        return account_money;
    }

    public void setAccount_money(Float account_money) {
        this.account_money = account_money;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
