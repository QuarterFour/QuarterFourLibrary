package com.a.quarter.model.base;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.a.quarter.model.utils.LoadingDialogUtils;
import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public abstract class BaseObserver<T> implements Observer<T> {

    private Context mContext;

    public BaseObserver(Context context) {
        this.mContext = context;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

        Log.e("onSubscribe: ","mContext="+  mContext);
        //进度条展示
        LoadingDialogUtils.showDialog(mContext);

    }

    @Override
    public void onNext(@NonNull T t) {

        success(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {

        if (e instanceof ApiException) {
//            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            ((ApiException)e).toastErr(mContext);
            Log.e("onError: ","dddddd"+  e.getMessage().toString() );

        } else if ((e instanceof UnknownHostException)) {
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof JsonSyntaxException) {
            Toast.makeText(mContext, "数据异常", Toast.LENGTH_SHORT).show();
        } else if (e instanceof SocketTimeoutException) {
            Toast.makeText(mContext, "连接超时", Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(mContext, "连接服务器失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "未知错误", Toast.LENGTH_SHORT).show();
        }
        Log.d("TAG", "e:" + e);
        Toast.makeText(mContext,e.toString(),Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onComplete() {
        //进度条关闭
        LoadingDialogUtils.hideDialog();
    }


    public abstract void success(T t);



}
