package com.maweiming.wechat.bot.service.unreadmsg;

import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 手机退出通知
 * @author CoderMa
 * @version PhoneExitNotice.java, v 0.1 2018-11-07 00:58
 */
@Service
public class PhoneExitNotice implements INotice {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhoneExitNotice.class);

    @Override
    public void process() {
        LOGGER.info("你在手机上退出了微信...");
        System.exit(0);
    }

}
