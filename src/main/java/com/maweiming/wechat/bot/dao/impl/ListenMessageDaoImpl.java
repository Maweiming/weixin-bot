package com.maweiming.wechat.bot.dao.impl;

import com.maweiming.wechat.bot.dao.ListenMessageDao;
import com.maweiming.wechat.bot.model.core.BaseRequest;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;
import com.maweiming.wechat.bot.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ListenMessageDaoImpl.java, v 0.1 2018-11-02 00:10
 */
@Repository
public class ListenMessageDaoImpl implements ListenMessageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenMessageDaoImpl.class);

    @Override
    public String pollingCheckUnreadMessage(String host, BaseRequest base, SyncKeyModel syncKey) {
        try {
            int time = TimeUtils.getTime();
            //r,sid,uin,skey,deviceid,synckey,_
            String params = String.format("r=%s&sid=%s&uin=%s&skey=%s&deviceid=%s&synckey=%s&_=%s",time,base.getSid(),base.getUin(),base.getSkey(),base.getDeviceID(),syncKey.getSyncKey(),time);
            params = URLEncoder.encode(params,HttpUtils.ENCODE);
            //host,params
            String url = String.format(WechatApiPool.GET_POLLING_CHECK_UNREAD_MESSAGE,host,params);
            String result = HttpUtils.get(url);
            return result;
        } catch (Exception e) {
            LOGGER.error("轮询check是否有未读消息时出现了异常",e);
        }
        return null;
    }

    @Override
    public String getMessage(ScanCode scanCode, LoginModel loginModel,SyncKeyModel syncKey) {
        String messageUrl = scanCode.getBaseUri()+WechatApiPool.POST_GET_MESSAGE;
        BaseRequest base = loginModel.toBaseRequest();
        //sid,skey,pass_ticket
        String url = String.format(messageUrl,base.getSid(),base.getSkey(),loginModel.getPass_ticket());
        Map<String,Object> params = new HashMap<>();
        params.put("BaseRequest",base);
        params.put("SyncKey",syncKey);
        params.put("rr",(-1-TimeUtils.getTime()));
        String result = HttpUtils.post(url, params, true);
        return result;
    }

    @Override
    public String getMessageImage(ScanCode scanCode, LoginModel loginModel,String messageId) {
        String messageImageUrl = scanCode.getBaseUri()+WechatApiPool.GET_MESSAGE_IMAGE;
        String url = String.format(messageImageUrl,messageId,loginModel.getSkey());
        return url;
    }

    @Override
    public String getMessageVideo(ScanCode scanCode, LoginModel loginModel, String messageId) {
        String messageVideoUrl = scanCode.getBaseUri()+WechatApiPool.GET_MESSAGE_VIDEO;
        String url = String.format(messageVideoUrl, messageId, loginModel.getSkey());
        return url;
    }

    @Override
    public String getMessageVoice(ScanCode scanCode, LoginModel loginModel, String messageId) {
        String voiceUrl = scanCode.getBaseUri()+WechatApiPool.GET_MESSAGE_VOICE;
        String url = String.format(voiceUrl, messageId, loginModel.getSkey());
        return url;
    }


}
