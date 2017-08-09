package com.a.quarter.view.iview;

import com.a.quarter.model.bean.AttentionBean;
import com.a.quarter.model.bean.HotBean;
import com.a.quarter.model.bean.HotVideoBean;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.bean.MyworksActivity_LocaBean;
import com.a.quarter.model.bean.SiginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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
    Observable<SiginBean> sigin(@Field("userName") String userName, @Field("userPassword") String userPassword, @Field("userPhone") String userPhone, @Field("userSex") String userSex);

    //登陆
    @FormUrlEncoded
    @POST("quarter/user/addLogin")
    Observable<LoginBean> login(@Field("userPhone") String username,
                                @Field("userPassword") String password
    );

    //热门接口
    @GET("quarter/user/findHot")
    Observable<HotBean> gethot();

    // TODO: 2017/8/2  收藏这边还不太确定
//    //收藏
//    @FormUrlEncoded
//    @POST("quarter/user/addLogin")
//    Observable<LoginBean> attention(@Field("userPhone") String username,
//                                @Field("userPassword") String password
    // );
//查询我关注的好友
    @GET("quarter/user/myFollow")
    Observable<AttentionBean> attention(@Query("Userid") int Userid);



    //热门视频接口
    @GET("quarter/media/showMedia")
    Observable<HotVideoBean> hot();

    //我的作品
    @GET("quarter/user/selectUserAll")
    Observable<MyworksActivity_LocaBean> Mywarks(@Query("id") int id);





}
