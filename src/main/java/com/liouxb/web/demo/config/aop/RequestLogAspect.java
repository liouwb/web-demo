package com.liouxb.web.demo.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liouwb
 */
@Slf4j
@Aspect
@Component
public class RequestLogAspect {
    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.liouxb.web.demo.controller..*.*(..))")
    public void webLog() {
    }

    /**
     * 前置增强
     * 打印请求相关信息
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        String invokeMethod = joinPoint.getSignature().getDeclaringTypeName();

        // 打印请求 参数信息
        log.info("Request Params URL: {} ,请求方式 : {} ,调用方法：{} , ip :{}", request.getRequestURI(), request.getMethod(), invokeMethod, request.getRemoteHost());
    }

//    /**
//     * 环绕增强
//     * 计算请求响应时间及返回参数
//     */
//    @Around("webLog()")
//    public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//
//        Object result = proceedingJoinPoint.proceed();
//
//
//        long endTime = System.currentTimeMillis();
//
//        // 打印结果
//        log.info("Response 参数： {} ,{} ,{} ,{} ", proceedingJoinPoint.getArgs(), proceedingJoinPoint.getTarget(), proceedingJoinPoint.getSourceLocation(), proceedingJoinPoint.getKind());
//
//
//    }

//    /**
//     * 环绕增强
//     * 计算请求响应时间及返回参数
//     */
//    @Around("webLog()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = proceedingJoinPoint.proceed();
//        // 打印出参
//        log.info("Response Args---: {}", result);
//        // 打印执行耗时
//        log.info("Time Consuming--: {} ms", System.currentTimeMillis() - startTime);
//        return result;
//    }
}
