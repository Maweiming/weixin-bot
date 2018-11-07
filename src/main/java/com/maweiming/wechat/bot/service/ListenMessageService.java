package com.maweiming.wechat.bot.service;

import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version listenMessageService.java, v 0.1 2018-11-01 00:53
 */
public interface ListenMessageService {

    void listen(ScanCode scanCode,LoginModel loginModel, SyncKeyModel syncKey);

}
