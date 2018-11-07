package com.maweiming.wechat.bot.service.unreadmsg;

import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 其他设备登陆通知
 * @author CoderMa
 * @version LoginOtherDeviceNotice.java, v 0.1 2018-11-07 00:04
 */
@Service
public class LoginOtherDeviceNotice implements INotice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginOtherDeviceNotice.class);

    @Override
    public void process() {
        LOGGER.info("你在其他地方登录了web微信...");
        System.exit(0);
    }

}
