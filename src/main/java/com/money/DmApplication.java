package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @version V1.0
 * @Package com.money
 * @ClassName DmApplication
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 21:37
 **/
@MapperScan("com.money.dao")
@SpringBootApplication
public class DmApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DmApplication.class,args);
    }
    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder){
        return builder.sources(DmApplication.class);
    }

}
