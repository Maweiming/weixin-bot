package com.maweiming.wechat.bot.model.login;

import com.maweiming.wechat.bot.model.core.BaseRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 登陆model
 * @author CoderMa
 * @version LoginModel.java, v 0.1 2018-10-31 00:55
 */
public class LoginModel {

    private String deviceId;

    private String skey;

    private String wxsid;

    private String wxuin;

    private String pass_ticket;

    public LoginModel() {
    }

    public LoginModel(String deviceId, String skey, String wxsid, String wxuin, String pass_ticket) {
        this.deviceId = deviceId;
        this.skey = skey;
        this.wxsid = wxsid;
        this.wxuin = wxuin;
        this.pass_ticket = pass_ticket;
    }

    public String getSkey() {
        return skey;
    }

    public void setSkey(String skey) {
        this.skey = skey;
    }

    public String getWxsid() {
        return wxsid;
    }

    public void setWxsid(String wxsid) {
        this.wxsid = wxsid;
    }

    public String getWxuin() {
        return wxuin;
    }

    public void setWxuin(String wxuin) {
        this.wxuin = wxuin;
    }

    public String getPass_ticket() {
        return pass_ticket;
    }

    public void setPass_ticket(String pass_ticket) {
        this.pass_ticket = pass_ticket;
    }

    public boolean isVerify(){
        return StringUtils.isNoneBlank(this.skey,this.wxsid,this.wxuin,this.pass_ticket);
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BaseRequest toBaseRequest(){
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setDeviceID(deviceId);
        baseRequest.setSid(wxsid);
        baseRequest.setSkey(skey);
        baseRequest.setUin(Long.valueOf(wxuin));
        return baseRequest;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
