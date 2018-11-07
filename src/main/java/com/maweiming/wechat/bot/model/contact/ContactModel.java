package com.maweiming.wechat.bot.model.contact;

import com.alibaba.fastjson.annotation.JSONField;
import com.maweiming.wechat.bot.model.initialization.BaseResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ContactModel.java, v 0.1 2018-11-01 00:51
 */
public class ContactModel {

    @JSONField(name = "BaseResponse")
    private BaseResponse baseResponse;

    @JSONField(name = "MemberCount")
    private Integer memberCount;

    @JSONField(name = "MemberList")
    private List<ContactMemberModel> memberList;

    @JSONField(name = "Seq")
    private Integer seq;

    public ContactModel() {
    }

    public ContactModel(BaseResponse baseResponse, Integer memberCount, List<ContactMemberModel> memberList, Integer seq) {
        this.baseResponse = baseResponse;
        this.memberCount = memberCount;
        this.memberList = memberList;
        this.seq = seq;
    }

    public BaseResponse getBaseResponse() {
        return baseResponse;
    }

    public void setBaseResponse(BaseResponse baseResponse) {
        this.baseResponse = baseResponse;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public List<ContactMemberModel> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<ContactMemberModel> memberList) {
        this.memberList = memberList;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
