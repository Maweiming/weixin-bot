package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.MessageType;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 小程序消息
 * @author CoderMa
 * @version MiniAppMessage.java, v 0.1 2019-03-28 21:34
 */
@Service
public class MiniAppMessage extends BaseMessage implements IMessage {
    @Override
    public void showMessage() {
        //分享标题
        String messageTitle = message.getFileName();
        //分享链接
        String messageUrl = message.getUrl();
        //显示内容
        String content = String.format("(%s)->%s",messageTitle,messageUrl);
        super.printMessage(content,MessageType.MINIAPP);
    }
}
