package com.maweiming.wechat.bot.model.group;

import com.alibaba.fastjson.annotation.JSONField;
import com.maweiming.wechat.bot.model.contact.ContactMemberModel;
import com.maweiming.wechat.bot.model.initialization.BaseResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version GroupModel.java, v 0.1 2018-11-01 22:08
 */
public class GroupModel {

    @JSONField(name = "BaseResponse")
    private BaseResponse baseResponse;

    @JSONField(name = "Count")
    private Integer count;

    @JSONField(name = "ContactList")
    private List<ContactMemberModel> contactList;

    public GroupModel() {
    }

    public GroupModel(BaseResponse baseResponse, Integer count, List<ContactMemberModel> contactList) {
        this.baseResponse = baseResponse;
        this.count = count;
        this.contactList = contactList;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ContactMemberModel> getContactList() {
        return contactList;
    }

    public void setContactList(List<ContactMemberModel> contactList) {
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
