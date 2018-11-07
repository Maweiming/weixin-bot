package com.maweiming.wechat.bot.service.message;

import com.alibaba.fastjson.JSON;
import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ActionMessage.java, v 0.1 2018-11-07 00:36
 */
@Service
public class ActionMessage extends BaseMessage implements IMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActionMessage.class);

    @Override
    public void showMessage() {
        Integer statusNotifyCode = message.getStatusNotifyCode();
        switch (statusNotifyCode){
            case 2:
                if(group){
                    LOGGER.info("你打开了->{}的群聊",msgToUserName);
                }else{
                    LOGGER.info("你打开了->{}的聊天窗口",msgToUserName);
                }
                break;
            case 5:
                if(group){
                    LOGGER.info("你关闭了->{}的群聊",msgToUserName);
                }else{
                    LOGGER.info("你关闭了->{}的聊天窗口",msgToUserName);
                }
                break;
            default:
                LOGGER.info(JSON.toJSONString(message));
                break;
        }
    }

}
