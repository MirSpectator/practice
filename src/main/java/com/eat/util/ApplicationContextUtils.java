package com.eat.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @Package com.eat.comom.util
 * @ClassName ApplicationContextUtils
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/10/29 23:47
 * TODO 用于手动获取@Bean
 **/
@Component // //注意:需要添加这个注解
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }
}