package com.maweiming.wechat.bot.windows;

import javax.swing.*;
import java.awt.*;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version QRCodeFrameImage.java, v 0.1 2018-10-31 23:50
 */
public class QRCodeFrameImage extends JPanel {

    private String imagePath;

    public QRCodeFrameImage(String imagePath) {
        this.imagePath = imagePath;
    }

    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon icon = new ImageIcon(imagePath);
        g.drawImage(icon.getImage(), 0, 0, 400, 400, this);
    }

}
