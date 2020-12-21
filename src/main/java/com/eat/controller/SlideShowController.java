package com.eat.controller;

import com.eat.comom.RspMsg;
import com.eat.entity.SlideShow;
import com.eat.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @Package com.eat.controller
 * @ClassName SlideShowController
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/11/23 21:56
 **/
@Controller
@ResponseBody
@RequestMapping(value = "SlideShow")
public class SlideShowController {

    @Autowired
    private SlideShowService slideShowService;

    @RequestMapping(value = "selectSildeShow.po", method = {RequestMethod.GET})
    public RspMsg selectSildeShow(){
        RspMsg rspMsg = this.slideShowService.selectSildeShow();
        System.out.println(rspMsg.getResult());
        System.out.println(rspMsg.getCode());
        System.out.println(rspMsg.getMsg());
        return rspMsg;
    }

    @RequestMapping(value = "deleteSildeShow.po", method = {RequestMethod.POST})
    public RspMsg deleteSildeShow(int id){
        return this.slideShowService.deleteSildeShow(id);
    }

    @RequestMapping(value = "addSildeShow.po",method = {RequestMethod.POST})
    public RspMsg addSildeShow(@RequestBody SlideShow slideShow) {
        return this.slideShowService.addSildeShow(slideShow);
    }

}
