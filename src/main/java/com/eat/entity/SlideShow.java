package com.eat.entity;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName slideshow
 * @Description 首页轮播图
 * @Author 王振鹏
 * @date 2020/10/16 22:44
 **/
public class SlideShow implements Serializable {
    private static final long serialVersionUID = 7800237876029526111L;

    private Integer slideshow_id;
    private String slideshow_img;
    private String slideshow_src;


    public SlideShow(Integer slideshow_id, String slideshow_img, String slideshow_src) {
        this.slideshow_id = slideshow_id;
        this.slideshow_img = slideshow_img;
        this.slideshow_src = slideshow_src;
    }

    public SlideShow() {
    }

    @Override
    public String toString() {
        return "SlideShow{" +
                "slideshow_id=" + slideshow_id +
                ", slideshow_img='" + slideshow_img + '\'' +
                ", slideshow_src='" + slideshow_src + '\'' +
                '}';
    }

    public String getSlideshow_src() {
        return slideshow_src;
    }

    public void setSlideshow_src(String slideshow_src) {
        this.slideshow_src = slideshow_src;
    }

    public Integer getSlideshow_id() {
        return slideshow_id;
    }

    public void setSlideshow_id(Integer slideshow_id) {
        this.slideshow_id = slideshow_id;
    }

    public String getSlideshow_img() {
        return slideshow_img;
    }

    public void setSlideshow_img(String slideshow_img) {
        this.slideshow_img = slideshow_img;
    }
}
