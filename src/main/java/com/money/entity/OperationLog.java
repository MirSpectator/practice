package com.money.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.money.entity
 * @ClassName OperationLog
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/21 19:27
 **/
public class OperationLog implements Serializable {
    private static final long serialVersionUID = 1759428204434462816L;

    private Integer operation_log_id;
    private String operation_log_params;
    private String operation_log_url;
    private String operation_log_return;
    private Date create_time;
    private Date update_time;


    public OperationLog() {
    }

    public OperationLog(Integer operation_log_id, String operation_log_params, String operation_log_url, String operation_log_return, Date create_time, Date update_time) {
        this.operation_log_id = operation_log_id;
        this.operation_log_params = operation_log_params;
        this.operation_log_url = operation_log_url;
        this.operation_log_return = operation_log_return;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "OperationLog{" +
                "operation_log_id=" + operation_log_id +
                ", operation_log_params='" + operation_log_params + '\'' +
                ", operation_log_url='" + operation_log_url + '\'' +
                ", operation_log_return='" + operation_log_return + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getOperation_log_id() {
        return operation_log_id;
    }

    public void setOperation_log_id(Integer operation_log_id) {
        this.operation_log_id = operation_log_id;
    }

    public String getOperation_log_params() {
        return operation_log_params;
    }

    public void setOperation_log_params(String operation_log_params) {
        this.operation_log_params = operation_log_params;
    }

    public String getOperation_log_url() {
        return operation_log_url;
    }

    public void setOperation_log_url(String operation_log_url) {
        this.operation_log_url = operation_log_url;
    }

    public String getOperation_log_return() {
        return operation_log_return;
    }

    public void setOperation_log_return(String operation_log_return) {
        this.operation_log_return = operation_log_return;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
