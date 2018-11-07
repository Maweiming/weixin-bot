package com.maweiming.wechat.bot.service.message.core;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version MessageCache.java, v 0.1 2018-11-06 00:26
 */
public class MessageCache {

    private String msgId;

    private String content;

    private MessageType type;

    public MessageCache() {
    }

    public MessageCache(String msgId, String content, MessageType type) {
        this.msgId = msgId;
        this.content = content;
        this.type = type;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
