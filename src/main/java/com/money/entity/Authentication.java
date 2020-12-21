package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName Authentication
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/21 19:24
 **/
public class Authentication implements Serializable {
    private static final long serialVersionUID = 7651802830940272528L;

    private String id_card;
    private String front_img;
    private String verso_img;
    private String face_img;
    private Date create_time;

    public Authentication() {
    }

    public Authentication(String id_card, String front_img, String verso_img, String face_img, Date create_time) {
        this.id_card = id_card;
        this.front_img = front_img;
        this.verso_img = verso_img;
        this.face_img = face_img;
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "id_card='" + id_card + '\'' +
                ", front_img='" + front_img + '\'' +
                ", verso_img='" + verso_img + '\'' +
                ", face_img='" + face_img + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getFront_img() {
        return front_img;
    }

    public void setFront_img(String front_img) {
        this.front_img = front_img;
    }

    public String getVerso_img() {
        return verso_img;
    }

    public void setVerso_img(String verso_img) {
        this.verso_img = verso_img;
    }

    public String getFace_img() {
        return face_img;
    }

    public void setFace_img(String face_img) {
        this.face_img = face_img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
