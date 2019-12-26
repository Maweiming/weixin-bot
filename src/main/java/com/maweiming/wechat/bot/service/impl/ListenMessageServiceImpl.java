package com.maweiming.wechat.bot.service.impl;

import com.maweiming.wechat.bot.dao.ListenMessageDao;
import com.maweiming.wechat.bot.model.core.BaseRequest;
import com.maweiming.wechat.bot.model.core.WechatCore;
import com.maweiming.wechat.bot.model.initialization.SyncKeyModel;
import com.maweiming.wechat.bot.model.listen.UnreadMessageModel;
import com.maweiming.wechat.bot.model.login.LoginModel;
import com.maweiming.wechat.bot.service.ListenMessageService;
import com.maweiming.wechat.bot.service.unreadmsg.core.INotice;
import com.maweiming.wechat.bot.service.unreadmsg.core.INoticeMsg;
import com.xiaoleilu.hutool.util.ReUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 监听消息
 *
 * @author CoderMa
 * @version ListenMessageService.java, v 0.1 2018-11-01 00:54
 */
@Service
public class ListenMessageServiceImpl implements ListenMessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListenMessageServiceImpl.class);

    @Value("#{'${wechat.hosts}'.split(',')}")
    private List<String> hosts;

    @Autowired
    private ListenMessageDao listenMessageDao;

    @Autowired
    private INoticeMsg iNoticeMsg;

    @Override
    public void listen() {
        SyncKeyModel syncKey = WechatCore.getSyncKey();
        LoginModel loginModel = WechatCore.getLoginModel();
        LOGGER.info("进入消息监听模式...");
        BaseRequest baseRequest = loginModel.toBaseRequest();
        //获取一个健康的微信节点
        UnreadMessageModel healthyNode = getHealthyNode(baseRequest, syncKey);
        LOGGER.info("get host={}", healthyNode.getHost());
        while (true) {
            try {
                Thread.sleep(1000);
                //check是否有最新消息
                UnreadMessageModel unreadMessage = pollingCheckUnreadMessage(healthyNode.getHost(), baseRequest, syncKey);
                if (null == unreadMessage) {
                    continue;
                }
                //创建通知工厂
                INotice noticeMsg = this.iNoticeMsg.createNoticeMsg(unreadMessage);
                //处理通知
                noticeMsg.process();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取一个健康的微信节点
     */
    private UnreadMessageModel getHealthyNode(BaseRequest baseRequest, SyncKeyModel syncKey) {
        LOGGER.info("find a healthy wechat node...");
        for (String host : hosts) {
            UnreadMessageModel unreadMessageModel = this.pollingCheckUnreadMessage(host, baseRequest, syncKey);
            if (unreadMessageModel.getRetCode() == 0) {
                LOGGER.info("host={}", unreadMessageModel);
                return unreadMessageModel;
            }
        }
        return null;
    }

    /**
     * 轮询check是否有未读消息
     */
    private UnreadMessageModel pollingCheckUnreadMessage(String host, BaseRequest baseRequest, SyncKeyModel syncKey) {
        Integer retcode = -1;
        Integer selector = -1;
        String content = listenMessageDao.pollingCheckUnreadMessage(host, baseRequest, syncKey);
        if (null != content) {
            String regex = "window.synccheck=\\{retcode:\"(\\d+)\",selector:\"(\\S+?)\"\\}";
            String retcodeStr = ReUtil.get(regex, content, 1);
            String selectorStr = ReUtil.get(regex, content, 2);
            if (StringUtils.isNoneBlank(retcodeStr, selectorStr)) {
                retcode = Integer.valueOf(retcodeStr);
                selector = Integer.valueOf(selectorStr);
            }
        }
        return new UnreadMessageModel(host, retcode, selector);
    }

}
