package com.maweiming.wechat.bot.model.initialization;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version MPSubscribeMsg.java, v 0.1 2018-11-01 00:34
 */
public class MPSubscribeMsg {

    @JSONField(name = "UserName")
    private String userName;

    @JSONField(name = "MPArticleCount")
    private Integer mPArticleCount;

    @JSONField(name = "MPArticleList")
    private List<MPArticle> mPArticleList;

    @JSONField(name = "Time")
    private Integer time;

    @JSONField(name = "NickName")
    private String nickName;

    public MPSubscribeMsg() {
    }

    public MPSubscribeMsg(String userName, Integer mPArticleCount, List<MPArticle> mPArticleList, Integer time, String nickName) {
        this.userName = userName;
        this.mPArticleCount = mPArticleCount;
        this.mPArticleList = mPArticleList;
        this.time = time;
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getmPArticleCount() {
        return mPArticleCount;
    }

    public void setmPArticleCount(Integer mPArticleCount) {
        this.mPArticleCount = mPArticleCount;
    }

    public List<MPArticle> getmPArticleList() {
        return mPArticleList;
    }

    public void setmPArticleList(List<MPArticle> mPArticleList) {
        this.mPArticleList = mPArticleList;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
