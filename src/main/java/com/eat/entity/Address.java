package com.eat.entity;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName address
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/30 0:56
 **/
public class Address implements Serializable {
    private static final long serialVersionUID = -7682437428128142720L;

    private Integer address_id;
    private String address_text;
    private String address_phone;
    private String adderss_person;
    private Integer id;

    public Address() {
    }

    public Address(Integer address_id, String address_text, String address_phone, String adderss_person, Integer id) {
        this.address_id = address_id;
        this.address_text = address_text;
        this.address_phone = address_phone;
        this.adderss_person = adderss_person;
        this.id = id;
    }

    @Override
    public String toString() {
        return "address{" +
                "address_id=" + address_id +
                ", address_text='" + address_text + '\'' +
                ", address_phone='" + address_phone + '\'' +
                ", adderss_person='" + adderss_person + '\'' +
                ", id=" + id +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getAddress_text() {
        return address_text;
    }

    public void setAddress_text(String address_text) {
        this.address_text = address_text;
    }

    public String getAddress_phone() {
        return address_phone;
    }

    public void setAddress_phone(String address_phone) {
        this.address_phone = address_phone;
    }

    public String getAdderss_person() {
        return adderss_person;
    }

    public void setAdderss_person(String adderss_person) {
        this.adderss_person = adderss_person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
