package com.eat.controller;

import com.eat.comom.RspMsg;
import com.eat.entity.Commodity;
import com.eat.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Package com.eat.controller
 * @ClassName CommodityController
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/28 0:30
 **/
@Controller
@ResponseBody
@RequestMapping(value = "Commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    /**
     * @Summary
     * @Param: []
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/28 0:34
     * @Description TODO
     */
    @RequestMapping(value = "selectCommodity.po",method = {RequestMethod.GET})
    public RspMsg selectCommodity(){
        return  this.commodityService.selectCommodity();
    }

    /**
     * @Summary
     * @Param: [commodity]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/28 0:34
     * @Description TODO
     */
    @RequestMapping(value = "addCommodity.po",method = {RequestMethod.POST})
    public RspMsg addCommodity(@RequestBody Commodity commodity){
        return  this.commodityService.addCommodity(commodity);
    }

    /**
     * @Summary
     * @Param: [commodity]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/28 0:33
     * @Description TODO
     */
    @RequestMapping(value = "updateCommodity.po",method = {RequestMethod.POST})
    public RspMsg updateCommodity(@RequestBody Commodity commodity){
        return  this.commodityService.updateCommodity(commodity);
    }

}
