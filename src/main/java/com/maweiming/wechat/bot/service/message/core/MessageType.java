package com.maweiming.wechat.bot.service.message.core;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version MessageType.java, v 0.1 2018-11-06 00:18
 */
public enum  MessageType {

    TEXT("文本"),
    IMAGES("图片"),
    VOICE("语音"),
    VIDEO("视频"),
    EMOJI("表情包"),
    RECALL("撤回一条消息"),
    LINK("分享链接"),
    MINIAPP("小程序"),
    OPEN("打开"),
    CLOSE("关闭")
    ;

    MessageType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
