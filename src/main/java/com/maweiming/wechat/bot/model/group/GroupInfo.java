package com.maweiming.wechat.bot.model.group;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version GroupInfo.java, v 0.1 2018-11-01 22:36
 */
public class GroupInfo {

    @JSONField(name = "UserName")
    private String userName;

    @JSONField(name = "EncryChatRoomId")
    private String encryChatRoomId = "";

    public GroupInfo() {
    }

    public GroupInfo(String userName) {
        this.userName = userName;
    }

    public GroupInfo(String userName, String encryChatRoomId) {
        this.userName = userName;
        this.encryChatRoomId = encryChatRoomId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryChatRoomId() {
        return encryChatRoomId;
    }

    public void setEncryChatRoomId(String encryChatRoomId) {
        this.encryChatRoomId = encryChatRoomId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
