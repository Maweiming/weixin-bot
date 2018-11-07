package com.maweiming.wechat.bot.service.unreadmsg.core;

import com.maweiming.wechat.bot.model.listen.UnreadMessageModel;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version IUnreadMsg.java, v 0.1 2018-11-07 00:54
 */
public interface INoticeMsg {

    INotice createNoticeMsg(UnreadMessageModel unreadMessage);

}
