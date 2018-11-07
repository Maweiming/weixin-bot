package com.maweiming.wechat.bot.dao;

import com.maweiming.wechat.bot.model.core.BaseRequest;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ListenMessageDao.java, v 0.1 2018-11-02 00:10
 */
public interface ListenMessageDao {

    /**
     * 轮询check是否有未读消息
     */
    String pollingCheckUnreadMessage(String host, BaseRequest base, SyncKeyModel syncKey);

    /**
     * 获取消息
     * @param loginModel
     * @return
     */
    String getMessage(ScanCode scanCode, LoginModel loginModel,SyncKeyModel syncKey);

    /**
     * 获取图片
     * @return
     */
    String getMessageImage(ScanCode scanCode, LoginModel loginModel,String messageId);

    /**
     * 获取视频
     * @return
     */
    String getMessageVideo(ScanCode scanCode, LoginModel loginModel,String messageId);

    /**
     * 获取语音
     */
    String getMessageVoice(ScanCode scanCode, LoginModel loginModel,String messageId);

}
