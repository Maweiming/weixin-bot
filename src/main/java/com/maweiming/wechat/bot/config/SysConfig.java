package com.maweiming.wechat.bot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version SysConfig.java, v 0.1 2018-11-06 00:06
 */
@Data
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
     * 特别关心内容
     */
    @Value("#{'${concerned.content.list}'.split(',')}")
    private List<String> concernedContentList;

    /**
     * 黑名单
     */
    @Value("#{'${blacklist}'.split(',')}")
    private List<String> blackList;

}
