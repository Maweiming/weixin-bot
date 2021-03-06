package com.maweiming.wechat.bot.model.core;

import com.maweiming.wechat.bot.model.contact.ContactMemberModel;
import com.maweiming.wechat.bot.model.contact.MemberModel;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.initialization.UserModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.model.scan.ScanCode;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version WechatCore.java, v 0.1 2018-11-01 00:51
 */
public class WechatCore {

    private static ScanCode scanCode;

    private static LoginModel loginModel;

    private static SyncKeyModel syncKey;

    /**
     * 当前用户
     */
    private static UserModel toUser;

    private static Map<String,String> userNameMap = new HashMap<>();

    /**
     * 获取用户昵称
     * @param fromUserName
     * @return
     */
    public static String getUserName(String fromUserName){
        String userName = userNameMap.get(fromUserName);
        if(StringUtils.isBlank(userName)){
            userName = fromUserName;
            if(null != userName && userName.startsWith("@@")){
                //没有加入通讯录的群聊
                return null;
            }
        }
        return userName;
    }

    /**
     * 设置当前用户
     * @param toUser
     */
    public static void setToUserData(UserModel toUser){
        userNameMap.put(toUser.getUserName(),toUser.getNickName());
        setToUser(toUser);
    }

    /**
     * 设置好友信息
     * @param contactList
     */
    public static void setContactData(List<ContactMemberModel> contactList){
        for (ContactMemberModel contact : contactList) {
            String contactId = contact.getUserName();
            String contactName = getMemberName(contact);
            if(!userNameMap.containsKey(contactId)){
                userNameMap.put(contactId,contactName);
            }
            List<MemberModel> memberList = contact.getMemberList();
            for (MemberModel memberModel : memberList) {
                String memberId = memberModel.getUserName();
                String memberName = getGroupMemberName(memberModel);
                if(!userNameMap.containsKey(memberId)){
                    userNameMap.put(memberId,memberName);
                }
            }
        }
    }

    /**
     * 获取群友昵称
     * @param member
     * @return
     */
    private static String getGroupMemberName(MemberModel member){
        String displayName = member.getDisplayName();
        String nickName = member.getNickName();
        if(StringUtils.isBlank(displayName)){
            return nickName;
        }
        return displayName;
    }

    /**
     * 获取好友昵称
     * @param member
     * @return
     */
    private static String getMemberName(ContactMemberModel member){
        String remarkName = member.getRemarkName();
        String nickName = member.getNickName();
        if(StringUtils.isBlank(remarkName)){
            return nickName;
        }
        return remarkName;
    }

    public static UserModel getToUser() {
        return toUser;
    }

    private static void setToUser(UserModel toUser) {
        WechatCore.toUser = toUser;
    }

    public static ScanCode getScanCode() {
        return scanCode;
    }

    public static void setScanCode(ScanCode scanCode) {
        WechatCore.scanCode = scanCode;
    }

    public static LoginModel getLoginModel() {
        return loginModel;
    }

    public static void setLoginModel(LoginModel loginModel) {
        WechatCore.loginModel = loginModel;
    }

    public static SyncKeyModel getSyncKey() {
        return syncKey;
    }

    public static void setSyncKey(SyncKeyModel syncKey) {
        WechatCore.syncKey = syncKey;
    }
}
