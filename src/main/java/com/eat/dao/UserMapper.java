package com.eat.dao;

import com.eat.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version V1.0
 * @Package com.eat.dao
 * @ClassName userMapper
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/14 23:08
 **/
public interface UserMapper {



    /**
     * @Summary
     * @Param: [user]
     * @Return: java.util.List<com.eat.entity.User>
     * @Author: TheRaging
     * @Date: 2020/10/26 22:25
     * @Description 通过用户实体类查询用户信息
     */
    List<User> SelectUserByUser(User user);


    /**
     * @Summary
     * @Param: [user]
     * @Return: int
     * @Author: TheRaging
     * @Date: 2020/10/26 22:24
     * @Description 添加用户，注册功能
     */
    int addUser(User user);


    /**
     * @Summary
     * @Param: [user]
     * @Return: int
     * @Author: TheRaging
     * @Date: 2020/11/17 21:24
     * @Description 修改用户的个人信息，以及登录加密信息和密码
     */
    int UpdateUserByPhone(User user);


    /**
     * @Summary
     * @Param: [user]
     * @Return: int
     * @Author: TheRaging
     * @Date: 2020/11/17 22:10
     * @Description 修改用户手机号
     */
    int UpdateUserPhone(@Param("old_Phone")String  old_Phone,@Param("new_phone")String new_phone);


}
