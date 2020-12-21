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

    private int id;
    private Float rate;
    private String type;
    private Date time;

    public Rate(int id, Float rate, String type, Date time) {
        this.id = id;
        this.rate = rate;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", rate=" + rate +
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
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
