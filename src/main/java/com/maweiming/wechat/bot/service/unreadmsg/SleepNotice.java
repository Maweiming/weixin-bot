package com.maweiming.wechat.bot.service.unreadmsg;

import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * sleep通知
 * @author CoderMa
 * @version NoMessageNotice.java, v 0.1 2018-11-07 00:07
 */
@Service
public class SleepNotice implements INotice {

    private static final Logger LOGGER = LoggerFactory.getLogger(SleepNotice.class);

    @Override
    public void process() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error,",e);
        }
    }

}
