package com.maweiming.wechat.bot.service;

import com.maweiming.wechat.bot.model.contact.ContactList;
import com.maweiming.wechat.bot.model.group.GroupModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;
import com.maweiming.wechat.bot.model.initialization.InitModel;
import com.maweiming.wechat.bot.model.initialization.UserModel;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version IWechat.java, v 0.1 2018-10-31 00:38
 */
public interface WechatService {

    /**
     * 获取uuid
     */
    String getUUID();

    /**
     * 等待扫码
     */
    ScanCode waitForLogin(String uuid, Integer tip);

    /**
     * 登陆
     */
    LoginModel login(ScanCode scanCode);

    /**
     * 初始化
     * @param loginModel
     */
    InitModel initialization(ScanCode scanCode, LoginModel loginModel);

    /**
     * 开启状态通知
     */
    String statusNotify(ScanCode scanCode,LoginModel loginModel,UserModel toUser);

    /**
     * 获取联系人列表
     */
    ContactList getContactList(ScanCode scanCode, LoginModel loginModel);

    /**
     * 获取群信息
     * @return
     */
    GroupModel getGroupInfo(ScanCode scanCode, LoginModel loginModel, ContactList contactList);

    /**
     * 获取单个群信息
     */
    GroupModel getGroupInfo(ScanCode scanCode, LoginModel loginModel, String groupId);

}
