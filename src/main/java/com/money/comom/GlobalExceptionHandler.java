package com.money.comom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @version V1.0
 * @Package com.money.comom
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/2 21:35
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理 Exception 异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(Exception.class)
    public com.money.comom.RspMsg handlerException(Exception e) {
        log.error("报错l");
        log.error(e.getMessage(), e);
        System.out.println(e.getMessage()+"123"+e);
        return com.money.comom.RspMsg.crmoneyeRspMsg(MsgConst.CODE_TYPE_IS_INVALID,MsgConst.MSG_CODE_TYPE_IS_INVALID);
    }

    /**
     * 处理空指针异常
     * @param e 异常
     * @return 处理结果
     */
    @ExceptionHandler(NullPointerException.class)
    public com.money.comom.RspMsg handlerNullPointerException(NullPointerException e) {
        log.error("报错l");
        log.error(e.getMessage(), e);
        return com.money.comom.RspMsg.crmoneyeRspMsg("1234","是空的");

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
