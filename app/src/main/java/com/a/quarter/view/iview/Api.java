package com.a.quarter.view.iview;

import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：总接口  retrofit
 * 思路：
 */

public interface Api {


    @GET()
    Observable<BaseBean<LoginBean>> Login(@Query("username") String username);

    @GET()
    Observable<BaseBean<LoginBean>> Login_(@Query("username") String username);






}
