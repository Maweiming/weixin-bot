package com.maweiming.wechat.bot.windows;

import com.maweiming.wechat.bot.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version Frame.java, v 0.1 2018-10-31 23:36
 */
@Component
public class QRCodeFrame extends JFrame {

    private Timer updateTitleTimer = new Timer();

    @Value("${wechat.qrcode.time}")
    private Integer time;

    private String qrcode;

    public void launchFrame(String qrcode) {
        this.qrcode = qrcode;
        updateFrameTitle();
        this.setVisible(true);
        this.setSize(420, 440);
        this.setLocation(100, 100);
        JPanel jPanel = new QRCodeFrameImage(this.qrcode);
        this.getContentPane().add(jPanel);
        this.setAlwaysOnTop(true);
    }

    public void closeWindows(){
        this.dispose();
        if(null != updateTitleTimer){
            updateTitleTimer.cancel();
            updateTitleTimer=null;
        }
    }

    private void updateFrameTitle(){
        if(null == updateTitleTimer){
            return;
        }
        updateTitleTimer.schedule(new TimerTask() {
            public void run() {
                time--;
                if(time<1){
                    closeWindows();
                    FileUtils.deleteFile(qrcode);
                }
                setTitle(String.format("请使用微信扫描二维码,%s秒后自动关闭",time));
                updateFrameTitle();
            }
        }, 1000);
    }

    public static void main(String[] args) {

        new QRCodeFrame().launchFrame("E:\\MyCoders\\weixin-bot\\target\\classes4eJwd3TgDg==");

    }

    public int getTime() {
        return time;
    }
}
