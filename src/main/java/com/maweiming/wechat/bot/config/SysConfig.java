package com.maweiming.wechat.bot.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version SysConfig.java, v 0.1 2018-11-06 00:06
 */
@Configuration
public class SysConfig {

    /**
     * 微信缓存地址
     */
    @Value("${wechat.cache.path}")
    public String wechatCachePath;

    /**
     * 特别关心列表
     */
    @Value("#{'${concerned.list}'.split(',')}")
    private List<String> concernedList;

    /**
     * 黑名单
     */
    @Value("#{'${blacklist}'.split(',')}")
    private List<String> blackList;

    public String getWechatCachePath() {
        return wechatCachePath;
    }

    public void setWechatCachePath(String wechatCachePath) {
        this.wechatCachePath = wechatCachePath;
    }

    public List<String> getConcernedList() {
        return concernedList;
    }

    public void setConcernedList(List<String> concernedList) {
        this.concernedList = concernedList;
    }

    public List<String> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<String> blackList) {
        this.blackList = blackList;
    }
}
