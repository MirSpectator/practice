package com.eat.service.impl;

import com.eat.comom.MsgConst;
import com.eat.comom.RspMsg;
import com.eat.dao.CommentMapper;
import com.eat.dao.CommodityMapper;
import com.eat.entity.Commodity;
import com.eat.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service.impl
 * @ClassName CommodityServiceImpl
 * @Description TODO 商品菜品表
 * @Author 王振鹏
 * @date 2020/11/27 22:08
 **/
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityMapper;

    /**
     * @Summary
     * @Param: [commodity]
     * @Return: int
     * @Author: TheRaging
     * @Date: 2020/11/27 22:20
     * @Description TODO
     */
    @Override
    public RspMsg addCommodity(Commodity commodity) {
        if(commodity == null){
            return RspMsg.createRspMsg(MsgConst.CODE_VAR_NOT_NULL, MsgConst.MSG_CODE_VAR_NOT_NULL);
        }
        int count = this.commodityMapper.addCommodity(commodity);
        if(count!=1){
            return RspMsg.createRspMsg(MsgConst.CODE_SQL_ADD_TOKEN_IS_INVALID, MsgConst.MSG_CODE_SQL_ADD_TOKEN_IS_INVALID);
        }
        return RspMsg.Success();
    }

    /**
     * @Summary
     * @Param: [commodity]
     * @Return: int
     * @Author: TheRaging
     * @Date: 2020/11/27 22:20
     * @Description TODO
     */
    @Override
    public RspMsg updateCommodity(Commodity commodity) {
        if(commodity == null){
            return RspMsg.createRspMsg(MsgConst.CODE_VAR_NOT_NULL, MsgConst.MSG_CODE_VAR_NOT_NULL);
        }
        int count = this.commodityMapper.updateCommodity(commodity);
        if(count!=1){
            return RspMsg.createRspMsg(MsgConst.CODE_SQL_ADD_TOKEN_IS_INVALID, MsgConst.MSG_CODE_SQL_ADD_TOKEN_IS_INVALID);
        }
        return RspMsg.Success();
    }

    /**
     * @Summary
     * @Param: []
     * @Return: java.util.List<com.eat.entity.Commodity>
     * @Author: TheRaging
     * @Date: 2020/11/27 22:20
     * @Description TODO
     */
    @Override
    public RspMsg selectCommodity() {
        List<Commodity> list = this.commodityMapper.selectCommodity();
        return RspMsg.Success(list);
    }
}
