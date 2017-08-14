package com.a.quarter.view.iview;

import com.a.quarter.model.bean.AttentionBean;
import com.a.quarter.model.bean.DisplayBean;
import com.a.quarter.model.bean.HotBean;
import com.a.quarter.model.bean.HotVideoBean;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.bean.MyworksActivity_LocaBean;
import com.a.quarter.model.bean.SatinCommentBean;
import com.a.quarter.model.bean.SatinPraiseBean;
import com.a.quarter.model.bean.SatinStepBean;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.model.bean.User_PublishBean;

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

//##############################################################################################################
    //段子显示页面的接口
    @GET("quarter/user/selectpiccha")
    Observable<DisplayBean> getData();


    //用户发表段子
    @FormUrlEncoded
    @POST("quarter/picture/picchaUpload")
    Observable<User_PublishBean> getCode(@Field("description") String description,
                                         @Field("dictionaryValue") int dictionaryValue,
                                         @Field("userId") int userId,
                                         @Field("content") String content);

    //http://192.168.1.100/quarter/character/AddNice?nicekey=55785s85f5af5357706f48f1ss2011sanice
    //段子点赞数
    @GET("quarter/character/AddNice")
    Observable<SatinPraiseBean> getSatinPraise_num(@Query("nicekey") String nicekey);



    /**
     * 接口好像不能用
     */
//    //段子转发数
//    @GET("quarter/user/selectpiccha")
//    Observable<SatinPraiseBean> getNice_num(@Query("nicekey") String nicekey);



    //段子评论数 (commentDictionaryValue)是固定的，是1
    @GET("quarter/user/selectpiccha")
    Observable<SatinCommentBean> getSatinComment(@Query("commentCharacterPictureMediaId") int commentCharacterPictureMediaId,
                                                 @Query("commentDictionaryValue") int commentDictionaryValue);


    //段子踩数
    @GET("quarter/user/selectpiccha")
    Observable<SatinStepBean> getStep_num(@Query("badkey") String badkey);




}
