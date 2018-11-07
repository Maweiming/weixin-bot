package com.maweiming.wechat.bot.utils;

import java.io.*;

/**
 * maweiming.com
 * Copyright (C) 1994-2018 All Rights Reserved.
 *
 * @author CoderMa
 * @version ApplicationMain.java, v 0.1 2018-10-31 00:43
 */
public class FileUtils {

    /**
     * delete file
     * @param filePath filePath
     */
    public static void deleteFile(String filePath){
        File file = new File(filePath);
        if(file.exists()){
            file.delete();
        }
    }

    /**
     * read file
     * @param filePath filePath
     * @return result
     */
    public static String readFile(String filePath) {
        File file = new File(filePath);
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            int fileLen = (int) file.length();
            char[] chars = new char[fileLen];
            try {
                reader.read(chars);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String text = String.valueOf(chars);
            return text;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * writer file
     * @param filePath filePath
     * @param content file content
     */
    public static void writer(String filePath, String content) {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
