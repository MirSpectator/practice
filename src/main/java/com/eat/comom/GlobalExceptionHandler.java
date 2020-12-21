package com.eat.comom;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version V1.0
 * @Package com.eat.comom
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/2 21:35
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理 Exception 异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(Exception.class)
    public RspMsg handlerException(Exception e) {
        //logger.error(e.getMessage(), e);
        System.out.println(e.getMessage()+"123"+e);
        return RspMsg.createRspMsg(MsgConst.CODE_TYPE_IS_INVALID,MsgConst.MSG_CODE_TYPE_IS_INVALID);
    }

    /**
     * 处理空指针异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(NullPointerException.class)
    public RspMsg handlerNullPointerException(NullPointerException e) {
        //logger.error(e.getMessage(), e);
        return RspMsg.createRspMsg("1234","是空的");

    }

    /**
     * 处理自定义异常
     * @param e 异常
     * @return 处理结果
     */
   /* @ExceptionHandler(GlobalException.class)
    public Result handlerGlobalException(GlobalException e) {
        logger.error(e.getMessage(), e);
        return Result.error().message(e.getMessage()).code(e.getCode());
    }*/

}
