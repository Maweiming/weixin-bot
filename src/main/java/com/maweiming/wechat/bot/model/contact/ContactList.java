package com.maweiming.wechat.bot.model.contact;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ContactList.java, v 0.1 2018-11-01 00:42
 */
public class ContactList {

    /**
     * 分享公众号
     */
    private List<ContactMemberModel> publicList;

    /**
     * 群聊
     */
    private List<ContactMemberModel> groupList;

    /**
     * 朋友
     */
    private List<ContactMemberModel> friendList;

    /**
     * 特殊账号（文件助手之类的）
     */
    private List<ContactMemberModel> specialList;

    public ContactList() {
    }

    public ContactList(List<ContactMemberModel> publicList, List<ContactMemberModel> groupList, List<ContactMemberModel> friendList, List<ContactMemberModel> specialList) {
        this.publicList = publicList;
        this.groupList = groupList;
        this.friendList = friendList;
        this.specialList = specialList;
    }

    public List<ContactMemberModel> getPublicList() {
        return publicList;
    }

    public void setPublicList(List<ContactMemberModel> publicList) {
        this.publicList = publicList;
    }

    public List<ContactMemberModel> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<ContactMemberModel> groupList) {
        this.groupList = groupList;
    }

    public List<ContactMemberModel> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<ContactMemberModel> friendList) {
        this.friendList = friendList;
    }

    public List<ContactMemberModel> getSpecialList() {
        return specialList;
    }

    public void setSpecialList(List<ContactMemberModel> specialList) {
        this.specialList = specialList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

