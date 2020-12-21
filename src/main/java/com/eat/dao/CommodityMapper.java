package com.eat.dao;

import com.eat.comom.RspMsg;
import com.eat.entity.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.dao
 * @ClassName CommodityMapper
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/16 23:08
 **/
public interface CommodityMapper {
    //TODO 上传菜品
    int addCommodity(Commodity commodity);

    //TODO 上架 下架菜品  修改菜品的详细信息
    int updateCommodity(Commodity commodity);

    //TODO 主页查询显示菜品
    List<Commodity> selectCommodity();
}
