package com.maweiming.wechat.bot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version HttpAop.java, v 0.1 2018-10-31 00:43
 */
@Aspect
@Component
public class HttpAop {

    private static final Logger LOGGER = LoggerFactory.getLogger("wechatHttp");

    /**
     * dao 方法切点
     */
    @Pointcut("execution(public * com.maweiming.wechat.bot.dao.*.*(..))")
    public void daoMethod() {
    }

    @Around("daoMethod()")
    public Object daoMethod(ProceedingJoinPoint pjp) throws Throwable {
        // 获得参数
        Object[] args = pjp.getArgs();
        String signatureJson = pjp.getSignature().toString();
        String method = signatureJson.substring(signatureJson.lastIndexOf(".")+1,signatureJson.lastIndexOf("("));
        // 调用目标方法
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed(args);
        long end = System.currentTimeMillis();
//        LOGGER.info("请求结束：time = {}ms ,method = {}, result = {}", (end - start), method, JSON.toJSONString(proceed));
        return proceed;
    }

}
