package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.MessageType;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version LinkMessage.java, v 0.1 2018-11-07 00:34
 */
@Service
public class LinkMessage extends BaseMessage implements IMessage {
    @Override
    public void showMessage() {
        //分享标题
        String messageTitle = message.getFileName();
        //分享链接
        String messageUrl = message.getUrl();
        //显示内容
        String content = String.format("(%s)->%s",messageTitle,messageUrl);
        super.printMessage(content,MessageType.LINK);
    }
}
