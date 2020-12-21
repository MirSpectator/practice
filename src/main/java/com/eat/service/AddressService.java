package com.eat.service;

import com.eat.comom.RspMsg;
import com.eat.entity.Address;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service
 * @ClassName AddressService
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/30 21:42
 **/
public interface AddressService {

    //TODO 添加收货地址
    RspMsg addAddress(Address address);

    //TODO 修改收货地址
    RspMsg updateAddress(Address address);

    //TODO 删除收获地址
    RspMsg deleteAddress(int address_id);

    //TODO 查询收货地址
    RspMsg selectAddress(int id);
}
