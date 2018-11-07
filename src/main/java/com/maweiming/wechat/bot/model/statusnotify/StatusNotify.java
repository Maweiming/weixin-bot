package com.maweiming.wechat.bot.model.statusnotify;

import com.alibaba.fastjson.annotation.JSONField;
import com.maweiming.wechat.bot.model.initialization.BaseResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version StatusNotify.java, v 0.1 2018-11-01 00:47
 */
public class StatusNotify {

    @JSONField(name = "BaseResponse")
    private BaseResponse baseResponse;

    @JSONField(name = "MsgID")
    private String msgID;

    public StatusNotify() {
    }

    public StatusNotify(BaseResponse baseResponse, String msgID) {
        this.baseResponse = baseResponse;
        this.msgID = msgID;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
