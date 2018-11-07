package com.maweiming.wechat.bot.model.listen;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version UnreadMessageModel.java, v 0.1 2018-11-02 00:26
 */
public class UnreadMessageModel {

    private String host;

    private Integer retCode;

    private Integer selector;

    public UnreadMessageModel() {
    }

    public UnreadMessageModel(String host, Integer retCode, Integer selector) {
        this.host = host;
        this.retCode = retCode;
        this.selector = selector;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Integer getSelector() {
        return selector;
    }

    public void setSelector(Integer selector) {
        this.selector = selector;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
