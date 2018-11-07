package com.maweiming.wechat.bot.utils;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version XMLUtils.java, v 0.1 2018-10-31 00:16
 */
public class XMLUtils {

    public static <T> T toObject(String xml,Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        Document doc = DocumentHelper.parseText(xml);
        Element root = doc.getRootElement();
        Iterator iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element el = (Element)iterator.next();
            String name = el.getName();
            Object data = el.getData();
            try {
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                field.set(t, data);
            }catch (NoSuchFieldException e){
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

}
