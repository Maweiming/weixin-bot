package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.dao.ListenMessageDao;
import com.maweiming.wechat.bot.model.core.WechatCore;
import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.MessageType;
import com.maweiming.wechat.bot.utils.HttpUtils;
import com.maweiming.wechat.bot.utils.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 图片消息
 * @author CoderMa
 * @version ImageMessage.java, v 0.1 2018-11-07 00:21
 */
@Service
public class ImageMessage extends BaseMessage implements IMessage {

    @Autowired
    private ListenMessageDao listenMessageDao;

    @Override
    public void showMessage() {
        String messageImage = getMessageImage(message.getMsgId());
        super.printMessage(messageImage,MessageType.IMAGES);
    }

    public String getMessageImage(String messageId) {
        String imageUrl = listenMessageDao.getMessageImage(WechatCore.getScanCode(), WechatCore.getLoginModel(), messageId);
        String imagePath = String.format("%s\\images\\%s.png",super.wechatCachePath,IdGenerate.getUUId());
        String result = HttpUtils.downloadImage(imageUrl,imagePath);
        return result;
    }

}
