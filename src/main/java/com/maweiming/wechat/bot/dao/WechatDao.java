package com.maweiming.wechat.bot.dao;

import com.maweiming.wechat.bot.model.group.GroupInfo;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;
import com.maweiming.wechat.bot.model.initialization.UserModel;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version IWechat.java, v 0.1 2018-10-31 00:38
 */
public interface WechatDao {

    /**
     * 获取UUID
     * @return
     */
    String getUUID();

    /**
     * 判断是否登陆
     * @param uuid
     * @return
     */
    String waitForLogin(String uuid,Integer tip);

    /**
     * 登陆
     */
    String login(ScanCode scanCode);

    /**
     * 初始化
     */
    String initialization(ScanCode scanCode,LoginModel loginModel);

    /**
     * 开启状态通知
     */
    String statusNotify(ScanCode scanCode,LoginModel loginModel,UserModel toUser);

    /**
     * 获取联系人列表
     */
    String getContactList(ScanCode scanCode,LoginModel loginModel);

    /**
     * 获取群信息
     * @return
     */
    String getGroupInfo(ScanCode scanCode,LoginModel loginModel,List<GroupInfo> groupInfoList);

}
