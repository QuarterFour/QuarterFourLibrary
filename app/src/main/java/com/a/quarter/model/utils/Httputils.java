package com.a.quarter.model.utils;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.system.Contant;
import com.a.quarter.view.iview.Api;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public class Httputils {
    public static<T> void retrofitUtils(Observable<T> observable, BaseObserver<T> observer) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static Api getApi() {
        Api api = new Retrofit.Builder()
                .baseUrl(Contant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Api.class);
        return api;
    }


}
