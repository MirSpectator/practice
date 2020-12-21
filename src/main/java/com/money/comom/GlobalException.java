package com.money.comom;


import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.eat.comom
 * @ClassName GlobalException
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/2 21:20
 **/
public class GlobalException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1458779406978659271L;
    /**
     * 保存异常信息
     */
    private String message;

    /**
     * 保存响应状态码
     */
    private Integer code = HttpStatus.SC_INTERNAL_SERVER_ERROR;

    /**
     * 默认构造方法，根据异常信息 构建一个异常实例对象
     * @param message 异常信息
     */
    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * 根据异常信息、响应状态码构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     */
    public GlobalException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    /**
     * 根据异常信息，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param e 异常对象
     */
    public GlobalException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    /**
     * 根据异常信息，响应状态码，异常对象构建 一个异常实例对象
     * @param message 异常信息
     * @param code 响应状态码
     * @param e 异常对象
     */
    public GlobalException(String message, Integer code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
