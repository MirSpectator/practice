package com.eat.service;

import com.eat.comom.RspMsg;
import com.eat.entity.SlideShow;

/**
 * @version V1.0
 * @Package com.eat.service
 * @ClassName SlideShowService
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/16 23:12
 **/
public interface SlideShowService {
    // TODO 添加首页轮播图
    RspMsg addSildeShow(SlideShow slideShow);

    // TODO 删除首页轮播图
    RspMsg deleteSildeShow(int  slideShow);

    // TODO 查询首页的轮播i图
    RspMsg selectSildeShow();

}
