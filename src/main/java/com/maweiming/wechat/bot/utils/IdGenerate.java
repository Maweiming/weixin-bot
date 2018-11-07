package com.maweiming.wechat.bot.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author Coder-Ma
 * @version IdGenerate.java, v 0.1 2018/5/31 00:58 Coder-Ma
 */
public class IdGenerate {

    /**
     * 获取uuid
     */
    public static String getUUId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 随机生成设备id
     */
    public static String getDeviceId(){
        double random = new Random().nextDouble();
        String deviceId = "e"+String.valueOf(random).substring(2, 17);
        return deviceId;
    }

}
