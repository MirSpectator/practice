package com.money.comom;


import org.springframework.util.StringUtils;

/**
 * @version V1.0
 * @Package com.money.util
 * @ClassName RspMsg
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/15 22:42
 **/
public class RspMsg<T extends Object> {

    private String code;
    private String msg;
    private T result;
    private static com.money.comom.RspMsg succRspMsg = null;

    public RspMsg() {
    }

    public RspMsg(String code) {
        this.code = code;
    }

    public RspMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RspMsg(String code, T result) {
        this.code = code;
        this.result = result;
    }

    public RspMsg(String code, String msg, T result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static com.money.comom.RspMsg crmoneyeRspMsg(String errCode, String errMsg) {
        if (StringUtils.isEmpty(errCode)) {
            errCode = "";
        }
        if (StringUtils.isEmpty(errMsg)) {
            errMsg = "";
        }
        return new com.money.comom.RspMsg(errCode, errMsg, "");
    }

    public static com.money.comom.RspMsg crmoneyeRspMsg(String errCode, String errMsg, Object result) {
        if (StringUtils.isEmpty(errCode)) {
            errCode = "";
        }
        if (StringUtils.isEmpty(errMsg)) {
            errMsg = "";
        }
        if (result instanceof String){
            if (StringUtils.isEmpty(result)) {
                result = "";
            }
        }else {
            if (null == result) {
                result = null;
            }
        }

        return new com.money.comom.RspMsg(errCode, errMsg, result);
    }

    public static com.money.comom.RspMsg crmoneyeRspMeg(Object result) {
        return new com.money.comom.RspMsg(MsgConst.SUCCESS_CODE, MsgConst.SUCCESS_MSG, result);
    }


    public static com.money.comom.RspMsg Success() {
        if (succRspMsg != null) {
            return succRspMsg;
        }
        return new com.money.comom.RspMsg(MsgConst.SUCCESS_CODE, MsgConst.SUCCESS_MSG, "");
    }

    public static com.money.comom.RspMsg Success(Object object) {
        return new com.money.comom.RspMsg(MsgConst.SUCCESS_CODE, MsgConst.SUCCESS_MSG, object);

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
