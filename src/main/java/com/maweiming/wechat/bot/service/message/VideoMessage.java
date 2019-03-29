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
 *
 * @author CoderMa
 * @version VideoMessage.java, v 0.1 2018-11-07 00:43
 */
@Service
public class VideoMessage extends BaseMessage implements IMessage {

    @Autowired
    private ListenMessageDao listenMessageDao;

    @Override
    public void showMessage() {
        String messageVideo = getMessageVideo(message.getMsgId());
        super.printMessage(messageVideo,MessageType.VIDEO);
    }

    public String getMessageVideo(String messageId) {
        String videoUrl = listenMessageDao.getMessageVideo(WechatCore.getScanCode(), WechatCore.getLoginModel(), messageId);
        String imagePath = String.format("%s/video/%s.mp4",super.sysConfig.wechatCachePath,IdGenerate.getUUId());
        String result = HttpUtils.downloadVideo(videoUrl,imagePath);
        return result;
    }

}
