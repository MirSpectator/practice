package com.eat.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName commodity
 * @Description TODO  菜品表
 * @Author 王振鹏
 * @date 2020/10/16 22:35
 * TODO 商品表
 **/
public class Commodity implements Serializable {
    private static final long serialVersionUID = 4159013755911067668L;

    private Integer commodity_id;
    private String commodity_img;
    private String commodity_title;
    private BigDecimal commodity_price;
    private String commodity_introduce;
    private Boolean commodity_status;

    public Commodity() {
    }

    public Commodity(Integer commodity_id, String commodity_img, String commodity_title, BigDecimal commodity_price, String commodity_introduce, Boolean commodity_status) {
        this.commodity_id = commodity_id;
        this.commodity_img = commodity_img;
        this.commodity_title = commodity_title;
        this.commodity_price = commodity_price;
        this.commodity_introduce = commodity_introduce;
        this.commodity_status = commodity_status;
    }

    @Override
    public String toString() {
        return "commodity{" +
                "commodity_id=" + commodity_id +
                ", commodity_img='" + commodity_img + '\'' +
                ", commodity_title='" + commodity_title + '\'' +
                ", commodity_price=" + commodity_price +
                ", commodity_introduce='" + commodity_introduce + '\'' +
                ", commodity_status=" + commodity_status +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodity_img() {
        return commodity_img;
    }

    public void setCommodity_img(String commodity_img) {
        this.commodity_img = commodity_img;
    }

    public String getCommodity_title() {
        return commodity_title;
    }

    public void setCommodity_title(String commodity_title) {
        this.commodity_title = commodity_title;
    }

    public BigDecimal getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(BigDecimal commodity_price) {
        this.commodity_price = commodity_price;
    }

    public String getCommodity_introduce() {
        return commodity_introduce;
    }

    public void setCommodity_introduce(String commodity_introduce) {
        this.commodity_introduce = commodity_introduce;
    }

    //0下架 1上架
    public Integer getCommodity_status() {
        if(commodity_status==null){
            return null;
        }
        if(commodity_status){
           return 1;
        }
        return 0;
    }

    public void setCommodity_status(Boolean commodity_status) {
        this.commodity_status = commodity_status;
    }
}
