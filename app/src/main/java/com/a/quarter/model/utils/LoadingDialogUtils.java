package com.a.quarter.model.utils;

import android.content.Context;
import android.util.Log;

import com.a.quarter.R;
import com.a.quarter.ui.LoadingDialog;


/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public class LoadingDialogUtils {


    private static LoadingDialog mLoadingDialog;

    public static void showDialog(Context context) {
        if (mLoadingDialog == null) {
            mLoadingDialog = new LoadingDialog(context, R.style.task_progress_dialog);
            mLoadingDialog.setCanceledOnTouchOutside(false);
            mLoadingDialog.setCancelable(true);
        }
        mLoadingDialog.show();
    }

    public static void hideDialog() {
        if (mLoadingDialog != null) {
            mLoadingDialog.dismiss();
        }
    }

}
