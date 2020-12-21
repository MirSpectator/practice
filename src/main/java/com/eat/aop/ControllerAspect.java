package com.eat.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @version V1.0
 * @Package com.eat.aop
 * @ClassName LogAspect
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/4 0:05
 **/
@Aspect
@Component
public class ControllerAspect {
    private Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


    /**
     * @Summary
     * @Param: []
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/10 22:04
     * @Description TODO 切入点
     */
    @Pointcut("execution(public * com.eat.controller.*.*(..))")
    public void myPointCut(){
        //签名，可以理解成这个切入点的一个名称
        logger.info("你好啊");
    }

    /***
     * @Summary
     * @Param: [joinPoint]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/10 22:03
     * @Description TODO 前置通知
     */
    @Before("myPointCut()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取url,请求方法，ip地址，类名以及方法名，参数
        logger.info("url={},method={},ip={},class_method={},args={}", request.getRequestURI(),request.getMethod(),request.getRemoteAddr(),joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),joinPoint.getArgs());

    }
    /**
     * @Summary
     * @Param: [joinPoint]
     * @Return: void
     * @Author: TheRaging
     * @Date: 2020/12/10 22:03
     * @Description TODO 后置通知
     */
    @AfterReturning(pointcut = "myPointCut()")
    public void printLog(JoinPoint joinPoint){

        logger.info(new Date()+"-----------");
    }
}