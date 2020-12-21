package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName Rate
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 21:45
 **/
public class Rate implements Serializable {
    private static final long serialVersionUID = -3940937625231270705L;

    private int rate_id;
    private Float rate;
    private String rate_type;
    private Date create_time;

    public Rate() {
    }

    public Rate(int rate_id, Float rate, String rate_type, Date create_time) {
        this.rate_id = rate_id;
        this.rate = rate;
        this.rate_type = rate_type;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rate_id=" + rate_id +
                ", rate=" + rate +
                ", rate_type='" + rate_type + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public int getRate_id() {
        return rate_id;
    }

    public void setRate_id(int rate_id) {
        this.rate_id = rate_id;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getRate_type() {
        return rate_type;
    }

    public void setRate_type(String rate_type) {
        this.rate_type = rate_type;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
