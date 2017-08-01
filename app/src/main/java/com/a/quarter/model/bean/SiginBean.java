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
     * code : 200
     */

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "SiginBean{" +
                "code=" + code +
                '}';
    }
}
