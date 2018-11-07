package com.maweiming.wechat.bot.model.scan;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 扫码model
 * @author CoderMa
 * @version LoginSuccess.java, v 0.1 2018-10-31 00:02
 */
public class ScanCode {

    private String redirectUri;

    private String baseUri;

    public ScanCode() {
    }

    public ScanCode(String redirectUri, String baseUri) {
        this.redirectUri = redirectUri;
        this.baseUri = baseUri;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
