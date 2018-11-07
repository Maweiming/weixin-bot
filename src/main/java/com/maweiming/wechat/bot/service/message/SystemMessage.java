package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.utils.DingMessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 系统消息
 * @author CoderMa
 * @version SystemMessage.java, v 0.1 2018-11-07 00:42
 */
@Service
public class SystemMessage extends BaseMessage implements IMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemMessage.class);

    @Autowired
    private DingMessageUtils dingMessageUtils;

    @Override
    public void showMessage() {
        String content = message.getContent();
        switch (content){
            case "收到红包，请在手机上查看":
                LOGGER.info(content);
                dingMessageUtils.sendMessage(content);
                break;
            default:
                LOGGER.info(content);
                break;
        }
    }
}
