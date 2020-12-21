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

    private int account_log_id;
    private int account_id;
    private Float money;
    private String account_log_type;
    private Date create_time;
    private Date update_time;

    public AccountLog(int account_log_id, int account_id, Float money, String account_log_type, Date create_time, Date update_time) {
        this.account_log_id = account_log_id;
        this.account_id = account_id;
        this.money = money;
        this.account_log_type = account_log_type;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public AccountLog() {
    }

    @Override
    public String toString() {
        return "AccountLog{" +
                "account_log_id=" + account_log_id +
                ", account_id=" + account_id +
                ", money=" + money +
                ", account_log_type='" + account_log_type + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public int getAccount_log_id() {
        return account_log_id;
    }

    public void setAccount_log_id(int account_log_id) {
        this.account_log_id = account_log_id;
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

    public String getAccount_log_type() {
        return account_log_type;
    }

    public void setAccount_log_type(String account_log_type) {
        this.account_log_type = account_log_type;
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
