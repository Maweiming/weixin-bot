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
 * 语音消息
 * @author CoderMa
 * @version VoiceMessage.java, v 0.1 2018-11-07 00:27
 */
@Service
public class VoiceMessage extends BaseMessage implements IMessage {

    @Autowired
    private ListenMessageDao listenMessageDao;

    @Override
    public void showMessage() {
        String messageVoice = getMessageVoice(message.getMsgId());
        super.printMessage(messageVoice,MessageType.VOICE);
    }

    public String getMessageVoice(String messageId) {
        String voiceUrl = listenMessageDao.getMessageVoice(WechatCore.getScanCode(), WechatCore.getLoginModel(), messageId);
        String voicePath = String.format("%s/voice/%s.mp3",super.sysConfig.wechatCachePath,IdGenerate.getUUId());
        String result = HttpUtils.downloadVideo(voiceUrl,voicePath);
        return result;
    }

}
