package com.eat.service.impl;

import com.eat.comom.MsgConst;
import com.eat.comom.RspMsg;
import com.eat.dao.AddressMapper;
import com.eat.entity.Address;
import com.eat.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service.impl
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/30 21:42
 **/
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    /**
     * @Summary
     * @Param: [address]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:43
     * @Description TODO 新建收获地址
     */
    @Override
    public RspMsg addAddress(Address address) {
        int count = this.addressMapper.addAddress(address);
        if(count!=1){
            return RspMsg.createRspMsg(MsgConst.CODE_ADD_SQL_IS_INVALID, MsgConst.MSG_CODE_ADD_SQL_IS_INVALID);
        }
        return RspMsg.Success();
    }

    /**
     * @Summary
     * @Param: [address]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:43
     * @Description 修改收货地址
     */
    @Override
    public RspMsg updateAddress(Address address) {
        int count = this.addressMapper.updateAddress(address);
        if(count!=1){
            return RspMsg.createRspMsg(MsgConst.CODE_UPDATE_SQL_IS_INVALID, MsgConst.MSG_CODE_UPDATE_SQL_IS_INVALID);
        }
        return RspMsg.Success();
    }

    /**
     * @Summary
     * @Param: [address_id]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:43
     * @Description TODO 删除收货地址
     */
    @Override
    public RspMsg deleteAddress(int address_id) {
        int count = this.addressMapper.deleteAddress(address_id);
        if(count!=1){
            return RspMsg.createRspMsg(MsgConst.CODE_DELETE_SQL_IS_INVALID, MsgConst.MSG_CODE_DELETE_SQL_IS_INVALID);
        }
        return RspMsg.Success();
    }

    /**
     * @Summary
     * @Param: [id]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:44
     * @Description TODO 查询收货地址
     */
    @Override
    public RspMsg selectAddress(int id) {
        List<Address> list = this.addressMapper.selectAddress(id);
        if(list.size()<0){

        }
        return RspMsg.Success(list);
    }
}
