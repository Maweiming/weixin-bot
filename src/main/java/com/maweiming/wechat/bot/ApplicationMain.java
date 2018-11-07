package com.maweiming.wechat.bot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ApplicationMain.java, v 0.1 2018-10-31 00:43
 */
@SpringBootApplication
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ApplicationMain.class);
        builder.headless(false).run(args);
    }


}
