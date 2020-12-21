package com.money.entity;

import java.io.Serializable;

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

    private int id;
    private int user_id;
    private String account_type;
    private Float account_money;
    private int rate_id;

    public Account(int id, int user_id, String account_type, Float account_money, int rate_id) {
        this.id = id;
        this.user_id = user_id;
        this.account_type = account_type;
        this.account_money = account_money;
        this.rate_id = rate_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", account_type='" + account_type + '\'' +
                ", account_money=" + account_money +
                ", rate_id=" + rate_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }
}
