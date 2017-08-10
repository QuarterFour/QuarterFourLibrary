package com.a.quarter.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.SuccessPresenter;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/31
 * 类用途：
 * 思路：
 */

public class SuccessActivity extends BaseActivity<SuccessPresenter> implements View.OnClickListener{


    private ImageView suc;
    private TextView ok;
    private ImageView qq_friend;
    private TextView qq_friend_text;
    private ImageView qqkl;
    private TextView qqkl_text;
    private ImageView friend_cricle;
    private TextView friend_cricle_text;
    private ImageView wechat;
    private TextView wechat_text;
    private Button button;


    /**
     * umShareListener为回调监听，构建如下:
     */
    private UMShareListener umShareListener = new UMShareListener() {

        //分享开始的回调
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        //分享成功的回调
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(SuccessActivity.this,"成功了",Toast.LENGTH_LONG).show();
        }

        //分享失败的回调
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(SuccessActivity.this,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }


        //@descrption 分享取消的回调
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(SuccessActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };






    @Override
    public Context context() {
        return this;
    }



    @Override
    protected void initView() {

        //添加6.0分享权限
        if(Build.VERSION.SDK_INT>=23){

            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};

            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }

        /////////////////////////////
        suc = (ImageView) findViewById(R.id.suc);
        ok = (TextView) findViewById(R.id.ok);

        //qq好友
        qq_friend = (ImageView) findViewById(R.id.qq_friend);
        qq_friend_text = (TextView) findViewById(R.id.qq_friend_text);

        //qq空间
        qqkl = (ImageView) findViewById(R.id.qqkl);
        qqkl_text = (TextView) findViewById(R.id.qqkl_text);

        //朋友圈
        friend_cricle = (ImageView) findViewById(R.id.friend_cricle);
        friend_cricle_text = (TextView) findViewById(R.id.friend_cricle_text);

        //微信
        wechat = (ImageView) findViewById(R.id.wechat);
        wechat_text = (TextView) findViewById(R.id.wechat_text);

        button = (Button) findViewById(R.id.button);

    }

    @Override
    protected void initData() {

        qq_friend.setOnClickListener(this);
        qqkl.setOnClickListener(this);
        friend_cricle.setOnClickListener(this);
        wechat.setOnClickListener(this);
        button.setOnClickListener(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_success;
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            //qq好友
            case R.id.qq_friend:

//                UMImage umImage = new UMImage(SuccessActivity.this, R.drawable.qq);

                UMWeb umWeb = new UMWeb("https://www.baidu.com/");
                umWeb.setTitle("我是盼盼，我很温柔可爱>_<");
//                umWeb.setThumb(umImage);
                umWeb.setDescription("hahahahahahahaha");
                new ShareAction(SuccessActivity.this)
                        .setPlatform(SHARE_MEDIA.QQ)//传入平台
                        .withMedia(umWeb)
                        //分享内容
                        .setCallback(umShareListener)//回调监听器
                        .share();
                break;
  
            //qq空间
            case R.id.qqkl:
                new ShareAction(SuccessActivity.this)
                        .setPlatform(SHARE_MEDIA.QZONE)//传入平台
                        .withText("hello")//分享内容
                        .setCallback(umShareListener)//回调监听器
                        .share();
                break;
            //朋友圈
            case R.id.friend_cricle:

                break;
            //微信
            case R.id.wechat:

                break;
            //button
            case R.id.button:

                Intent intent = new Intent(context(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }




    }

    /**
     *    QQ或新浪的分享需要添加的
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    /**
     * 用户是否同意了授权。如果没有同意，可以根据回调进行相应处理：
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {


    }



}
