package com.eat.dao;

import com.eat.entity.SlideShow;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.dao
 * @ClassName SlideShowMapper
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/16 23:08
 **/
public interface SlideShowMapper {
    // TODO 添加首页的轮播图
    int addSildeShow(SlideShow slideShow);

    // TODO 删除首页的轮播图
    int deleteSildeShow(int slideShow);

    // TODO 查询首页的轮播退
    List<SlideShow> selectSildeShow();
}
