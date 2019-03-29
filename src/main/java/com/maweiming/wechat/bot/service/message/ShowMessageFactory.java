package com.maweiming.wechat.bot.service.message;

import com.alibaba.fastjson.JSON;
import com.maweiming.wechat.bot.model.listen.AddMessage;
import com.maweiming.wechat.bot.service.message.core.IMessage;
import com.maweiming.wechat.bot.service.message.core.IShowMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 * 消息工厂
 * @author CoderMa
 * @version ShowMessageFactoryImpl.java, v 0.1 2018-11-07 00:01
 */
@Service
public class ShowMessageFactory implements IShowMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShowMessageFactory.class);

    /**
     * 普通消息
     */
    @Autowired
    private TextMessage textMessage;

    /**
     * 图片消息
     */
    @Autowired
    private ImageMessage imageMessage;

    /**
     * 语音消息
     */
    @Autowired
    private VoiceMessage voiceMessage;

    /**
     * 视频消息
     */
    @Autowired
    private VideoMessage videoMessage;

    /**
     * 表情包
     */
    @Autowired
    private EmojiMessage emojiMessage;

    /**
     * 链接
     */
    @Autowired
    private LinkMessage linkMessage;

    /**
     * 动作
     */
    @Autowired
    private ActionMessage actionMessage;

    /**
     * 系统消息
     */
    @Autowired
    private SystemMessage systemMessage;

    /**
     * 撤回消息
     */
    @Autowired
    private RecallMessage recallMessage;

    /**
     * 小程序消息
     */
    @Autowired
    private MiniAppMessage miniAppMessage;

    @Override
    public IMessage createMessage(AddMessage message) {
        //消息工厂
        IMessage messageFactory = null;
        //应用消息类型
        Integer appMsgType = message.getAppMsgType();
        //消息类型
        Integer msgType = message.getMsgType();
        //判断消息类型
        switch (msgType){
            case 1:
                //普通消息
                messageFactory = textMessage;
                break;
            case 3:
                //图片
                messageFactory = imageMessage;
                break;
            case 34:
                //语音
                messageFactory = voiceMessage;
                break;
            case 43:
                //视频
                messageFactory = videoMessage;
                break;
            case 47:
                //表情包
                messageFactory = emojiMessage;
                break;
            case 49:
                switch (appMsgType){
                    case 5:
                        //链接
                        messageFactory = linkMessage;
                        break;
                    case 8:
                        //表情包
                        messageFactory = emojiMessage;
                        break;
                    case 33:
                        //小程序
                        messageFactory = miniAppMessage;
                        break;
                    default:
                        LOGGER.info("appMsgType={},msgType={}未知的消息,message={}",appMsgType,msgType,message);
                }
                break;
            case 51:
                //动作(打开聊天窗口,关闭聊天窗口)
                messageFactory = actionMessage;
                break;
            case 10000:
                //系统消息
                messageFactory = systemMessage;
                break;
            case 10002:
                //撤回消息
                messageFactory = recallMessage;
                break;
            default:
                LOGGER.info("msgType={}未知的消息,message={}",msgType,message);
                break;
        }
        //初始化数据
        messageFactory.initData(message);
        return messageFactory;
    }
}
