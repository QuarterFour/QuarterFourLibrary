package com.a.quarter.model.base;

import android.content.Context;

/**
 * 异常类
 */

public class ApiException extends RuntimeException {

    private BaseBean tBean;

    public ApiException(BaseBean tBean) {
        this.tBean = tBean;
    }

    public void toastErr(Context context) {

        switch (tBean.getCode()) {
            case 1101://登录过期

                break;
            case 1102://验证码发送失败
                break;

        }
    }
}
