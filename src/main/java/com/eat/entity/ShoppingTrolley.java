package com.eat.entity;

import java.io.Serializable;

/**
 * @version V1.0
 * @Package com.eat.entity
 * @ClassName shopping_trolley
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/16 22:24
 * TODO 购物车
 **/
public class ShoppingTrolley implements Serializable {
    private static final long serialVersionUID = 1787675672646625443L;
    private Integer shopping_Trolley_id;
    private Integer user_id;
    private String commodity;

    @Override
    public String toString() {
        return "shopping_trolley{" +
                "shopping_Trolley_id=" + shopping_Trolley_id +
                ", user_id='" + user_id + '\'' +
                ", commodity='" + commodity + '\'' +
                '}';
    }

    public ShoppingTrolley(Integer shopping_Trolley_id, Integer user_id, String commodity) {
        this.shopping_Trolley_id = shopping_Trolley_id;
        this.user_id = user_id;
        this.commodity = commodity;
    }

    public Integer getShopping_Trolley_id() {
        return shopping_Trolley_id;
    }

    public void setShopping_Trolley_id(Integer shopping_Trolley_id) {
        this.shopping_Trolley_id = shopping_Trolley_id;
    }

    public Integer getuser_id() {
        return user_id;
    }

    public void setuser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }
}
