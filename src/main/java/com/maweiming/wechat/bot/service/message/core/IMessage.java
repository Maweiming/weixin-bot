package com.maweiming.wechat.bot.service.message.core;

import com.maweiming.wechat.bot.model.listen.AddMessage;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ShowMessage.java, v 0.1 2018-11-07 00:02
 */
public interface IMessage {

    void showMessage();

    void initData(AddMessage message);

}
