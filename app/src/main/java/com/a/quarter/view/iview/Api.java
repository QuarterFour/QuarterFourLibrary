package com.a.quarter.view.iview;

import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.bean.HotBean;
import com.a.quarter.model.bean.LoginBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：总接口  retrofit
 * 思路：
 */

public interface Api {


    //    @GET()
//    Observable<BaseBean<LoginBean>> Login(@Query("username") String username);
//
//    @GET()
//    Observable<BaseBean<LoginBean>> Login_(@Query("username") String username);
    //注册
    @FormUrlEncoded
    @POST("yikezhong/user/addUse")
    Call<BaseBean<LoginBean>> sigin(@Field("username") String username,
                                    @Field("password") String password,
                                    @Field("userPhone") String userPhone,
                                    @Field("userSex") String userSex);

    //登陆
    @FormUrlEncoded
    @POST("yikezhong/user/addLogin")
    Call<BaseBean<LoginBean>> login(@Field("username") String username,
                                    @Field("password") String password
                                    );

    @GET("quarter/media/showMedia")
    Observable<HotBean> hot();




}
