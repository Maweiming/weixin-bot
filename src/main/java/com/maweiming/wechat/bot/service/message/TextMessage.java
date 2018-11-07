package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.MessageType;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 普通消息
 * @author CoderMa
 * @version OrdinaryMessage.java, v 0.1 2018-11-07 00:07
 */
@Service
public class TextMessage extends BaseMessage implements IMessage {

    @Override
    public void showMessage() {
        String[] contentArray = message.getContent().split(":<br/>");
        String content = (super.senderIsMe||!super.group) ? contentArray[0]:contentArray[1];
        //打印消息
        super.printMessage(content,MessageType.TEXT);
    }

}
