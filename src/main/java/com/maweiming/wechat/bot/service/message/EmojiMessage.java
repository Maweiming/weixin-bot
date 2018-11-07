package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.BaseMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.MessageType;
import com.xiaoleilu.hutool.util.ReUtil;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version EmojiMessage.java, v 0.1 2018-11-07 00:30
 */
@Service
public class EmojiMessage extends BaseMessage implements IMessage {

    @Override
    public void showMessage() {
        String imageUrl = ReUtil.get("cdnurl = \\\\\"(\\S+?)\\\\\"", message.getContent(), 1);
        if(null == imageUrl){
            imageUrl = ReUtil.get("cdnurl = \\\"(\\S+?)\\\"", message.getContent(), 1);
        }
        if(null == imageUrl){
            imageUrl="表情包请在手机上查看";
        }
        super.printMessage(imageUrl,MessageType.EMOJI);
    }

}
