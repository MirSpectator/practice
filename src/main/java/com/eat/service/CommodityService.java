package com.eat.service;

import com.eat.comom.RspMsg;
import com.eat.entity.Commodity;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service
 * @ClassName CommodityService
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/27 22:08
 **/
public interface CommodityService {

    //TODO 上传菜品
    RspMsg addCommodity(Commodity commodity);

    //TODO 上架 下架菜品  修改菜品的详细信息
    RspMsg updateCommodity(Commodity commodity);

    //TODO 主页查询显示菜品
    RspMsg selectCommodity();

}
