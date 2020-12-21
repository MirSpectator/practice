package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName Account
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 21:48
 **/
public class AccountLog implements Serializable {
    private static final long serialVersionUID = 6826238208879916626L;

    private int id;
    private int user_id;
    private int account_id;
    private Float money;
    private String type;
    private Date time;


    public AccountLog(int id, int user_id, int account_id, Float money, String type, Date time) {
        this.id = id;
        this.user_id = user_id;
        this.account_id = account_id;
        this.money = money;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", account_id=" + account_id +
                ", money=" + money +
                ", type='" + type + '\'' +
                ", time=" + time +
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

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
