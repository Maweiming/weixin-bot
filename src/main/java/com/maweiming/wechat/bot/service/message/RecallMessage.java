package com.maweiming.wechat.bot.service.message;

import com.maweiming.wechat.bot.service.message.core.*;
import com.xiaoleilu.hutool.util.ReUtil;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 撤回消息
 * @author CoderMa
 * @version RecallMessage.java, v 0.1 2018-11-07 00:46
 */
@Service
public class RecallMessage extends BaseMessage implements IMessage {
    @Override
    public void showMessage() {
        String msgId = ReUtil.get("msgid&gt;(\\d+)&lt;/msgid", message.getContent(), 1);
        MessageCache messageCache = MessageCacheUtils.get(msgId);
        String content = null;
        if(null != messageCache){
            //显示内容
            content = String.format("%s->%s,MsgId=%s",MessageType.RECALL.getName(),messageCache.getContent(),message.getMsgId());
        }else{
            content = String.format("%s,MsgId=%s",MessageType.RECALL.getName(),message.getMsgId());
        }
        super.printMessage(content,MessageType.RECALL);
    }
}
