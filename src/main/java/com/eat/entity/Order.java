package com.eat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName Order
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/16 22:13
 **/
public class Order implements Serializable {
    private static final long serialVersionUID = -4337153300687039708L;
    private String order_id;
    private String order_wx;
    private Date order_endTime;
    private Date order_startTime;
    private BigDecimal order_money;
    private String user_openid;
    private String user_phone;
    private String order_commoditys;



    public Order(String order_id, String order_wx, Date order_endTime, Date order_startTime, BigDecimal order_money, String user_openid, String user_phone, String order_commoditys) {
        this.order_id = order_id;
        this.order_wx = order_wx;
        this.order_endTime = order_endTime;
        this.order_startTime = order_startTime;
        this.order_money = order_money;
        this.user_openid = user_openid;
        this.user_phone = user_phone;
        this.order_commoditys = order_commoditys;
    }



    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", order_wx='" + order_wx + '\'' +
                ", order_endTime=" + order_endTime +
                ", order_startTime=" + order_startTime +
                ", order_money=" + order_money +
                ", user_openid='" + user_openid + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", order_commoditys='" + order_commoditys + '\'' +
                '}';
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public void setOrder_wx(String order_wx) {
        this.order_wx = order_wx;
    }

    public void setOrder_endTime(Date order_endTime) {
        this.order_endTime = order_endTime;
    }

    public void setOrder_startTime(Date order_startTime) {
        this.order_startTime = order_startTime;
    }

    public void setOrder_money(BigDecimal order_money) {
        this.order_money = order_money;
    }

    public void setUser_openid(String user_openid) {
        this.user_openid = user_openid;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setOrder_commoditys(String order_commoditys) {
        this.order_commoditys = order_commoditys;
    }

    public String getOrder_id() {
        return order_id;
    }

    public String getOrder_wx() {
        return order_wx;
    }

    public Date getOrder_endTime() {
        return order_endTime;
    }

    public Date getOrder_startTime() {
        return order_startTime;
    }

    public BigDecimal getOrder_money() {
        return order_money;
    }

    public String getUser_openid() {
        return user_openid;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getOrder_commoditys() {
        return order_commoditys;
    }
}
