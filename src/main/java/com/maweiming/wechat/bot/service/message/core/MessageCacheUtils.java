package com.maweiming.wechat.bot.service.message.core;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version MessageCache.java, v 0.1 2018-11-06 00:23
 */
public class MessageCacheUtils {

    /**
     * 缓存最大消息数量
     */
    private volatile static Integer maxLength = 1000;

    private volatile static List<String> messageList = new ArrayList<>();

    private volatile static Map<String,MessageCache> messageMap = new HashMap<>();

    /**
     * 获取消息
     */
    public static MessageCache get(String msgId){
        return messageMap.get(msgId);
    }

    /**
     * 存储消息
     */
    public static Integer put(MessageCache message){
        String msgId = message.getMsgId();
        messageMap.put(msgId,message);
        messageList.add(msgId);
        int size = messageList.size();
        if(size>maxLength){
            messageMap.remove(messageList.get(0));
            messageList.remove(0);
        }
        return size;
    }

}
