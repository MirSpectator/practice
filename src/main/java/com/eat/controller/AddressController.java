package com.eat.controller;

import com.eat.comom.RspMsg;
import com.eat.entity.Address;
import com.eat.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Package com.eat.controller
 * @ClassName aDDRESScONTROLLER
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/30 21:52
 **/
@Controller
@ResponseBody
@RequestMapping(value = "Address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * @Summary
     * @Param: [address]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:57
     * @Description TODO 添加收货地址
     */
    @RequestMapping(value = "addAddress.po",method = {RequestMethod.POST})
    public RspMsg addAddress(@RequestBody Address address){
       return this.addressService.addAddress(address);
    }

    /**
     * @Summary
     * @Param: [address]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:58
     * @Description TODO 修改收货地址
     */
    @RequestMapping(value = "updateAddress.po",method = {RequestMethod.POST})
    public RspMsg updateAddress(@RequestBody Address address){
        return this.addressService.updateAddress(address);
    }

    /**
     * @Summary
     * @Param: [address_id]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:58
     * @Description TODO 删除收货地址
     */
    @RequestMapping(value = "deleteAddress.po",method = {RequestMethod.POST})
    public RspMsg deleteAddress( int address_id){
        return this.addressService.deleteAddress(address_id);
    }

    /**
     * @Summary
     * @Param: [id]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/30 21:58
     * @Description TODO 查询收货地址
     */
    @RequestMapping(value = "selectAddress.po",method = {RequestMethod.GET})
    public RspMsg selectAddress(int id){
        System.out.println(id);
        return this.addressService.selectAddress(id);
    }


}
