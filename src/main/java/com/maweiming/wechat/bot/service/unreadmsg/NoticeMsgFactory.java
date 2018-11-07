package com.maweiming.wechat.bot.service.unreadmsg;

import com.maweiming.wechat.bot.model.listen.UnreadMessageModel;
import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import com.maweiming.wechat.bot.service.unreadmsg.core.INoticeMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version UnreadMsgFactory.java, v 0.1 2018-11-07 00:54
 */
@Service
public class NoticeMsgFactory implements INoticeMsg {

    /**
     * 手机退出
     */
    @Autowired
    private PhoneExitNotice phoneExitNotice;

    /**
     * 其他设备登陆
     */
    @Autowired
    private LoginOtherDeviceNotice loginOtherDeviceNotice;

    /**
     * sleep通知
     */
    @Autowired
    private SleepNotice sleepNotice;

    /**
     * 新消息通知
     */
    @Autowired
    private NewMessageNotice newMessageNotice;

    @Override
    public INotice createNoticeMsg(UnreadMessageModel unreadMessage) {
        //通知
        INotice notice = null;
        Integer retCode = unreadMessage.getRetCode();
        Integer selector = unreadMessage.getSelector();
        switch (retCode) {
            case 1100:
                //手机退出
                notice = phoneExitNotice;
                break;
            case 1101:
                //其他设备登陆
                notice = loginOtherDeviceNotice;
                break;
            case 0:
                switch (selector) {
                    case 0:
                        //没有消息
                        notice = sleepNotice;
                        break;
                    case 2:
                    case 6:
                    case 7:
                        //新消息通知
                        notice = newMessageNotice;
                        break;
                    default:
                        //没有消息
                        notice = sleepNotice;
                        break;
                }
                break;
            default:
                //没有消息
                notice = sleepNotice;
                break;
        }
        return notice;
    }

}
