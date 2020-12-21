package com.eat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * TODO
 * @Package com.eat.entity
 * @ClassName comment
 * @Description 评论表
 * @Author 王振鹏
 * @date 2020/10/16 22:39
 **/
public class Comment implements Serializable {
    private static final long serialVersionUID = 7888728196197332603L;

    private Integer comment_id;
    private String comment_user_openid;
    private Integer comment_order_id;
    private String comment_text;
    private Date comment_time;

    @Override
    public String toString() {
        return "comment{" +
                "comment_id=" + comment_id +
                ", comment_user_openid='" + comment_user_openid + '\'' +
                ", comment_order_id=" + comment_order_id +
                ", comment_text='" + comment_text + '\'' +
                ", comment_time=" + comment_time +
                '}';
    }

    public Comment(Integer comment_id, String comment_user_openid, Integer comment_order_id, String comment_text, Date comment_time) {
        this.comment_id = comment_id;
        this.comment_user_openid = comment_user_openid;
        this.comment_order_id = comment_order_id;
        this.comment_text = comment_text;
        this.comment_time = comment_time;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_user_openid() {
        return comment_user_openid;
    }

    public void setComment_user_openid(String comment_user_openid) {
        this.comment_user_openid = comment_user_openid;
    }

    public Integer getComment_order_id() {
        return comment_order_id;
    }

    public void setComment_order_id(Integer comment_order_id) {
        this.comment_order_id = comment_order_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
}
