package com.maweiming.wechat.bot.utils;

import com.maweiming.wechat.bot.service.impl.ListenMessageServiceImpl;
import com.xiaoleilu.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version DingMessageUtils.java, v 0.1 2018-11-05 00:17
 */
@Component
public class DingMessageUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DingMessageUtils.class);

    private static final String ADMIN = "https://oapi.dingtalk.com/robot/send?access_token=";

    /**
     * 钉钉机器人token
     */
    @Value("${dingding.token}")
    private String token;

    @Value("微信客户端")
    private String projectName;

    public void sendMessage(String content) {
        try {
            if(null == token){
                LOGGER.info("token is null...");
                return;
            }
            /** 钉钉推送消息 */
            com.xiaoleilu.hutool.json.JSONObject messageMsg = new com.xiaoleilu.hutool.json.JSONObject().put("msgtype", "text")
                    .put("text", new com.xiaoleilu.hutool.json.JSONObject().put("content", String.format("%s->%s", projectName, content)))
                    .put("at", new com.xiaoleilu.hutool.json.JSONObject()
                            .put("isAtAll", true)
                    );
            HttpRequest.post(ADMIN + token).body(messageMsg).execute().body();
        } catch (Exception e) {
            LOGGER.error("sendMessage error,",e);
        }
    }

}
