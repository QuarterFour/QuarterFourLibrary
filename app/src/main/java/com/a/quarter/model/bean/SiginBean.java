package com.a.quarter.model.bean;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/28 10
 */

public class SiginBean {

    /**
     * code : 500!message:13717736250已存在!!!!!!
     */

    private String code;

    /**
     * code : 200
     */



    @Override
    public String toString() {
        return "SiginBean{" +
                "code=" + code +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
