package com.eat.comom;

/**
 * @version V1.0
 * @Package com.eat.util
 * @ClassName msg
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/15 22:51
 **/
public class MsgConst {


    /**
     * 公共
     */
    public static String SUCCESS_CODE = "0000";
    public static String SUCCESS_MSG = "成功";

    /***
     * @Summary
     * @Param:
     * @Return:
     * @Author: TheRaging
     * @Date: 2020/10/17 22:17
     * @Description 餐饮小程序的返回代码
     */
    // TODO 数据传输错误
    public static final String CODE_CLASS_NOT_NULL = "1011";
    public static final String MSG_CODE_CLASS_NOT_NULL = "传输的对象数据解析失败";

    // TODO 数据不全
    public static final String CODE_VAR_NOT_NULL = "1012";
    public static final String MSG_CODE_VAR_NOT_NULL = "传输的变量参数不能为空";

    // TODO sql运行失败
    public static final String CODE_SQL_NOT_NULL = "1013";
    public static final String MSG_CODE_SQL_NOT_NULL = "传输的json不能为空";

    // TODO
    public static final String CODE_TOKEN_IS_INVALID = "0011";
    public static final String MSG_CODE_TOKEN_IS_INVALID = "TOKEN不存在";

    // TODO 身份校验错误
    public static final String CODE_CREAT_TOKEN_IS_INVALID = "0012";
    public static final String MSG_CODE_CREAT_TOKEN_IS_INVALID = "TOKEN生成失败";

    // TODO 修改信息失败
    public static final String CODE_UPDATE_SQL_IS_INVALID = "2001";
    public static final String MSG_CODE_UPDATE_SQL_IS_INVALID = "修改失败";

    // TODO 删除信息失败
    public static final String CODE_DELETE_SQL_IS_INVALID = "2002";
    public static final String MSG_CODE_DELETE_SQL_IS_INVALID = "删除失败";

    // TODO 添加信息失败
    public static final String CODE_ADD_SQL_IS_INVALID = "2003";
    public static final String MSG_CODE_ADD_SQL_IS_INVALID = "添加失败";

    // TODO  储存TOKEN的加密密钥到数据库失败
    public static final String CODE_SQL_ADD_TOKEN_IS_INVALID = "2002";
    public static final String MSG_CODE_SQL_ADD_TOKEN_IS_INVALID = "储存TOKEN信息失败";

    // TODO  储存TOKEN的加密密钥到数据库失败
    public static final String CODE_REDIS_ADD_TOKEN_IS_INVALID = "2002";
    public static final String MSG_CODE_REDIS_ADD_TOKEN_IS_INVALID = "缓存失败";

    // TODO  用户创建失败
    public static final String CODE_CREAT_USER_IS_INVALID = "1002";
    public static final String MSG_CODE_CREAT_USER_IS_INVALID = "用户创建失败";




    /**
     * 用户
     */
    public static final String CODE_PHONE_AND_CODE_TYPE_NOT_NULL = "1001";
    public static final String MSG_CODE_PHONE_AND_CODE_TYPE_NOT_NULL = "手机号跟验证码类型不能为空";

    public static final String CODE_TYPE_IS_INVALID = "1002";
    public static final String MSG_CODE_TYPE_IS_INVALID = "验证码类型(codeType)输入错误(默认是:1),请重新输入";

    public static final String CODE_PHONE_NOT_NULL = "1003";
    public static final String MSG_PHONE_NOT_NULL = "手机号不能为空";

    public static final String CODE_VERIFY_CODE_NOT_NULL = "1004";
    public static final String MSG_CODE_VERIFY_CODE_NOT_NULLL = "验证码不能为空";

    public static final String CODE_VERIFY_ID_NOT_NULL = "1005";
    public static final String MSG_CODE_VERIFY_ID_NOT_NULL = "验证码ID 标识符不能为空";

    public static final String CODE_INVITED_CODE_NOT_NULL = "1006";
    public static final String MSG_CODE_INVITED_CODE_NOT_NULL = "用户邀请码不能为空";

    public static final String CODE_VERIFY_CODE_IS_INVALID = "1007";
    public static final String MSG_CODE_VERIFY_CODE_IS_INVALID = "用户验证码无效,登录失败";

    public static final String CODE_VERIFY_CODE_IS_INVALID_02 = "1008";
    public static final String MSG_CODE_VERIFY_CODE_IS_INVALID_02 = "用户验证码无效,注册失败";

    public static final String CODE_USER_INFO_IS_NULL = "1009";
    public static final String MSG_CODE_USER_INFO_IS_NULL = "用户信息不存在,请先注册";

    public static final String CODE_USER_INFO_IS_EXIST = "2001";
    public static final String MSG_CODE_USER_INFO_IS_EXIST = "用户信息已存在,无需注册,请直接登录";

    public static final String CODE_PARENT_ID_IS_NOT_NULL = "2002";
    public static final String MSG_CODE_PARENT_ID_IS_NOT_NULL = "上级用户id不能为空";

    public static final String CODE_JUNIOR_USER_INFO_IS_NULL = "2003";
    public static final String MSG_CODE_JUNIOR_USER_INFO_IS_NULL = "通过上级id获取下级用户信息为空";

    public static final String CODE_USER_ID_IS_NOT_NULL = "2004";
    public static final String MSG_CODE_USER_ID_IS_NOT_NULL = "用户id不能为空";

    public static final String CODE_ORDER_TYPE_IS_NOT_NULL = "3001";
    public static final String MSG_CODE_ORDER_TYPE_IS_NOT_NULL = "订单类型不能为空";


    public static final String CODE_USER_ORDER_INFO_IS_NULL = "3002";
    public static final String MSG_CODE_USER_ORDER_INFO_IS_NULL = "用户订单信息不存在";

    public static final String CODE_EXCEL_EXPORT_FAIL = "4001";
    public static final String MSG_CODE_EXCEL_EXPORT_FAIL = "Excel文件导入失败";

    public static final String CODE_EXCEL_EXPORT_SUCCESS = "4002";
    public static final String MSG_CODE_EXCEL_EXPORT_SUCCESS = "Excel文件导入成功";

    public static final String CODE_EXCEL_EXPORT_ERROR = "4003";
    public static final String MSG_CODE_EXCEL_EXPORT_ERROR = "文件格式错误,请导入Excel文件";


    //邀请码 InvitationCode
    public static final String CODE_INVITATION_CODE_ERROR = "6002";
    public static final String MSG_CODE_INVITATION_CODE_ERROR = "邀请码输入错误,请重新确认！";

    //添加用户信息
    public static final String CODE_USER_INSERT_ERROR = "6003";
    public static final String MSG_CODE_USER_INSERT_ERROR = "用户信息添加失败，请确保数据正确！";

    //驗證用戶手機唯一性
    public static final String CODE_USER_PHONE_ERROR = "6004";
    public static final String MSG_CODE_USER_PHONE_ERROR = "用户信息添加失败，手機號重複請再次確認信息完整性!";

    //用户导入验证  父类用户不存在
    public static final String CODE_EXCEL_EXPORT_PARENT_ERROR = "7003";
    public static final String MSG_CODE_EXCEL_EXPORT_PARENT_ERROR = "文件导入错误，值不存在，请查看父类手机号是否正确！";

    public static final String CODE_EXCEL_EXPORT_PARENTPHONE_ERROR = "7004";
    public static final String MSG_CODE_EXCEL_EXPORT_PARENTPHONE_ERROR = "文件导入错误，请查看父类手机号是否正确！";

    public static final String CODE_EXCEL_EXPORT_PHONEIS_ERROR = "7005";
    public static final String MSG_CODE_EXCEL_PHONEIS_ERROR = "文件导入错误，请查看导入手机号格式是否正确！";

}

