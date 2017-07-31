package com.a.quarter.model.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/31
 * 类用途：
 * 思路：
 */

public class StreamTools {

    public static String readFromNetWork(InputStream inputStream){

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] bytes = new byte[1024];

        int len = 0;

        try {

            while ((len = inputStream.read(bytes)) != -1){
                baos.write(bytes,0,len);
            }
            return baos.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


}
