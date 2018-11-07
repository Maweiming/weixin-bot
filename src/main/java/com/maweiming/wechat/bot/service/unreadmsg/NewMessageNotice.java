package com.maweiming.wechat.bot.service.unreadmsg;

import com.alibaba.fastjson.JSON;
import com.maweiming.wechat.bot.dao.ListenMessageDao;
import com.maweiming.wechat.bot.model.core.WechatCore;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.listen.AddMessage;
import com.maweiming.wechat.bot.model.listen.MessageModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.IShowMessage;
import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version NewMessageNotice.java, v 0.1 2018-11-07 00:09
 */
@Service
public class NewMessageNotice implements INotice {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewMessageNotice.class);

    @Autowired
    private SleepNotice sleepNotice;

    @Autowired
    private ListenMessageDao listenMessageDao;

    @Autowired
    private IShowMessage showMessage;

    @Override
    public void process() {
        //获取最新消息
        MessageModel message = this.getNewMessage();
        if (message.getBaseResponse().verify()) {
            for (AddMessage newMessage : message.getAddMsgList()) {
                //创建消息工厂
                IMessage messageFactory = showMessage.createMessage(newMessage);
                //显示消息
                messageFactory.showMessage();
            }
            //更新同步key,表示该消息已读,微信就不会在推送该消息了
            WechatCore.setSyncKey(message.getSyncKey());
        }
        //sleep
        sleepNotice.process();
    }

    /**
     * 获取最新消息
     */
    public MessageModel getNewMessage() {
        String content = listenMessageDao.getMessage(WechatCore.getScanCode(), WechatCore.getLoginModel(), WechatCore.getSyncKey());
        MessageModel message = JSON.parseObject(content, MessageModel.class);
        return message;
    }

}
