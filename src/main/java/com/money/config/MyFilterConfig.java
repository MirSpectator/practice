package com.money.config;

import com.money.filter.Myfilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @version V1.0
 * @Package com.money.config
 * @ClassName MyFilterConfig
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 23:28
 **/
@Configuration
public class MyFilterConfig implements WebMvcConfigurer {

    @Autowired
    private Myfilter myfilter;

    /**
     * @Summary
     * @Param: [registry]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/20 23:37
     * @Description TODO 配置静态资源目录使用
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    /**
     * @Summary
     * @Param: [registry]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/20 23:37
     * @Description TODO 配置自定义拦截器生效
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myfilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.po");

    }
}
