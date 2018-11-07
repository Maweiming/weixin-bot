package com.maweiming.wechat.bot.utils;

import java.lang.reflect.Method;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ClassUtils.java, v 0.1 2018-10-31 00:09
 */
public class ClassUtils {

    /**
     * 通过方法名调用方法
     * @param clazz 调用的Class
     * @param methodName 调用的方法名
     * @param param 调用的参数
     */
    public static <T> void invokeMethod(Class<?> clazz, String methodName, T param) {
        try {
            Method m1 = clazz.getDeclaredMethod(methodName, new Class[]{param.getClass()});
            m1.invoke(clazz.newInstance(), new Object[]{param});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
