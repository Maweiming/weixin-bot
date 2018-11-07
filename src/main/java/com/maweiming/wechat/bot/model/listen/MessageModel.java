package com.maweiming.wechat.bot.model.listen;

import com.alibaba.fastjson.annotation.JSONField;
import com.maweiming.wechat.bot.model.initialization.BaseResponse;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version MessageModel.java, v 0.1 2018-11-02 00:11
 */
public class MessageModel {

    @JSONField(name = "BaseResponse")
    private BaseResponse baseResponse;

    @JSONField(name = "SyncKey")
    private SyncKeyModel syncKey;

    @JSONField(name = "AddMsgList")
    private List<AddMessage> addMsgList;

    public MessageModel() {
    }

    public MessageModel(BaseResponse baseResponse, SyncKeyModel syncKey, List<AddMessage> addMsgList) {
        this.baseResponse = baseResponse;
        this.syncKey = syncKey;
        this.addMsgList = addMsgList;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public SyncKeyModel getSyncKey() {
        return syncKey;
    }

    public void setSyncKey(SyncKeyModel syncKey) {
        this.syncKey = syncKey;
    }

    public List<AddMessage> getAddMsgList() {
        return addMsgList;
    }

    public void setAddMsgList(List<AddMessage> addMsgList) {
        this.addMsgList = addMsgList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
