package com.maweiming.wechat.bot.model.core;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version BaseRequest.java, v 0.1 2018-11-01 00:59
 */
public class BaseRequest {

    @JSONField(name = "DeviceID")
    private String deviceID;

    @JSONField(name = "Sid")
    private String sid;

    @JSONField(name = "Skey")
    private String skey;

    @JSONField(name = "Uin")
    private Long uin;

    public BaseRequest() {
    }

    public BaseRequest(String deviceID, String sid, String skey, Long uin) {
        this.deviceID = deviceID;
        this.sid = sid;
        this.skey = skey;
        this.uin = uin;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public Long getUin() {
        return uin;
    }

    public void setUin(Long uin) {
        this.uin = uin;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
