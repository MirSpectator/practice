package com.eat.dao;

import com.eat.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.dao
 * @ClassName AddressMapper
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/30 1:01
 **/
public interface AddressMapper {

    //TODO 添加收货地址
    int addAddress(Address address);

    //TODO 修改收货地址
    int updateAddress(Address address);

    //TODO 删除收获地址
    int deleteAddress(int address_id);

    //TODO 查询收货地址
    List<Address> selectAddress(int id);

}
