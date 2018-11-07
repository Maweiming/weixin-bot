package com.maweiming.wechat.bot.service.message.core;

import com.maweiming.wechat.bot.model.listen.AddMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 消息工厂
 * @author CoderMa
 * @version ShowMessageFactory.java, v 0.1 2018-11-07 00:00
 */
public interface IShowMessage {

    IMessage createMessage(AddMessage message);

}
