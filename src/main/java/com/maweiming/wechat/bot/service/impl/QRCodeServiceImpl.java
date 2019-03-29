package com.maweiming.wechat.bot.service.impl;

import com.maweiming.wechat.bot.service.QRCodeService;
import com.maweiming.wechat.bot.utils.FileUtils;
import com.maweiming.wechat.bot.utils.QrcodeUtils;
import com.maweiming.wechat.bot.utils.WechatApiPool;
import com.maweiming.wechat.bot.windows.QRCodeFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version QRCodeServiceImpl.java, v 0.1 2018-10-31 22:00
 */
@Service
public class QRCodeServiceImpl implements QRCodeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeServiceImpl.class);

    @Value("${wechat.cache.path}")
    public String wechatCachePath;

    @Autowired
    private QRCodeFrame qrCodeFrame;

    @Override
    public void show(String uuid) {
        new Thread(() -> {
            showQRCode(uuid);
        }).start();
    }

    @Override
    public void close() {
        qrCodeFrame.closeWindows();
    }

    /**
     * 显示二维码
     * @param uuid
     */
    public void showQRCode(String uuid){
        try {
            LOGGER.info("正在渲染登陆二维码...");
            Path path = new File(String.format("%s/%s.png",wechatCachePath,uuid)).toPath();
            LOGGER.info("正在生成二维码,{}",path.toString());
            QrcodeUtils.createQrcode(String.format(WechatApiPool.QRCODE_FORMAT,uuid),path);
            qrCodeFrame.launchFrame(path.toString());
            LOGGER.info(String.format("请使用微信扫描二维码,二维码将在%s秒后失效",qrCodeFrame.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
