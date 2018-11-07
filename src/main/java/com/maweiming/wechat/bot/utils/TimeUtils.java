package com.maweiming.wechat.bot.utils;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version TimeUtils.java, v 0.1 2018-10-31 00:46
 */
public class TimeUtils {

    public static int getTime(){
        long time = System.currentTimeMillis();
        return (int)(time/1000);
    }

}
