package com.a.quarter.view.iview;

import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.bean.SiginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @POST("quarter/user/addUser")
    Observable<SiginBean> sigin(@Field("userName") String username,
                                          @Field("userPassword") String password,
                                          @Field("userPhone") String userPhone,
                                          @Field("userSex") String userSex);

    //登陆
    @FormUrlEncoded
    @POST("quarter/user/addLogin")
    Observable<LoginBean> login(@Field("userPhone") String username,
                                    @Field("userPassword") String password
                                    );
}
