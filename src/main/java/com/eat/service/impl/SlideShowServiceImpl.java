package com.eat.service.impl;

import com.eat.comom.MsgConst;
import com.eat.comom.RspMsg;
import com.eat.dao.SlideShowMapper;
import com.eat.entity.SlideShow;
import com.eat.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.service.impl
 * @ClassName SlideShowServiceImpl
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/17 22:14
 **/
@Service
public class SlideShowServiceImpl implements SlideShowService {

    @Autowired
    SlideShowMapper slideShowMapper;


    /***
     * @Summary
     * @Param: [slideShow]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/10/17 22:15
     * @Description 添加轮播图
     */
    @Override
    public RspMsg addSildeShow(SlideShow slideShow) {
        System.out.println(slideShow.toString());
        if(slideShow == null){
            return RspMsg.createRspMsg(MsgConst.CODE_CLASS_NOT_NULL, MsgConst.MSG_CODE_CLASS_NOT_NULL);
        }else if(slideShow.getSlideshow_img()==null){
            return RspMsg.createRspMsg(MsgConst.CODE_VAR_NOT_NULL, MsgConst.MSG_CODE_VAR_NOT_NULL );
        }else{
            int count = slideShowMapper.addSildeShow(slideShow);
            if(count!=1){
                return RspMsg.createRspMsg(MsgConst.CODE_SQL_NOT_NULL, MsgConst.MSG_CODE_SQL_NOT_NULL);
            }
        }
        return RspMsg.Success();
    }

    /***
     * @Summary
     * @Param: [slideShow]
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/10/17 22:15
     * @Description 删除轮播图
     */
    @Override
    public RspMsg deleteSildeShow(int slideShow) {


        int count = slideShowMapper.deleteSildeShow(slideShow);
        if(count!=1){
                return RspMsg.createRspMsg(MsgConst.CODE_SQL_NOT_NULL, MsgConst.MSG_CODE_SQL_NOT_NULL);
        }
        return RspMsg.Success();
    }

    /***
     * @Summary
     * @Param: []
     * @Return: com.eat.comom.RspMsg
     * @Author: TheRaging
     * @Date: 2020/11/23 19:12
     * @Description TODO 查询首页的轮播图
     */
    @Override
    public RspMsg selectSildeShow() {
        List<SlideShow> list = this.slideShowMapper.selectSildeShow();
        return RspMsg.Success(list);
    }
}
