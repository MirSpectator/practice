package com.money.filter;

import com.money.utils.Jwt;
import com.money.utils.impl.CacheUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version V1.0
 * @Package com.money.filter
 * @ClassName Myfilter
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 23:27
 **/
@Component
public class Myfilter implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(Myfilter.class);

    @Autowired
    private Jwt jwt;


    /**
     * @Summary
     * @Param: [request, response, handler]
     * @Return: boolean
     * @Author: TheRaging
     * @Date: 2020/12/20 23:31
     * @Description TODO  在执行Controller里的方法之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        log.info("token---------"+token);
        String publicKeyStr = CacheUtil.get(token);
        log.info("publicKeyStr------"+publicKeyStr);
        return  jwt.verifyTokenBoolean(token, publicKeyStr);
        //return true;
    }

    /**
     * @Summary
     * @Param: [request, response, handler, modelAndView]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/20 23:31
     * @Description TODO
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * @Summary
     * @Param: [request, response, handler, ex]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/20 23:31
     * @Description TODO
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
