package com.maweiming.wechat.bot.model.listen;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version AddMessageAppInfo.java, v 0.1 2018-11-02 00:25
 */
public class AddMessageAppInfo {

    @JSONField(name = "AppID")
    private String appID;

    @JSONField(name = "Type")
    private Integer type;

    public AddMessageAppInfo() {
    }

    public AddMessageAppInfo(String appID, Integer type) {
        this.appID = appID;
        this.type = type;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
