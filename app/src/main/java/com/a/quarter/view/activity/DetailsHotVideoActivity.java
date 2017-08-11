package com.a.quarter.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import com.a.quarter.R;
import com.a.quarter.view.view.ItemIjkPlayerView;
import com.dl7.player.media.IjkPlayerView;;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/26
 * 类的作用:
 * 实现思路:
 */

public class DetailsHotVideoActivity extends AppCompatActivity implements ItemIjkPlayerView.OnPlayCircleClickListener{

    private boolean mBackPressed;
    private String videoSrc;
    private CheckBox backCheckBox;
    private CheckBox likeCheckBox;
    private CheckBox unlikeCheckBox;
    private CheckBox downCheckBox;
    private ItemIjkPlayerView mPlayerView;
    //    private LinearLayout writeLinear;
    private static final String VIDEO_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/SD/movie_index.m3u8";
    private static final String VIDEO_HD_URL = "http://flv2.bn.netease.com/videolib3/1611/28/GbgsL3639/HD/movie_index.m3u8";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_hot_details);
        initDate();
        initView();
        initIjkPlay();
        initEvent();
    }
//获得从列表页传来的数据
    private void initDate() {
        Intent intent = getIntent();
        videoSrc = intent.getStringExtra("VideoSrc");
    }
//初始化控件
    private void initView() {
        backCheckBox = (CheckBox) findViewById(R.id.Detail_Back);
        likeCheckBox = (CheckBox) findViewById(R.id.Detail_like);
        unlikeCheckBox = (CheckBox) findViewById(R.id.Detail_unlike);
        downCheckBox = (CheckBox) findViewById(R.id.Detail_down);
        mPlayerView = (ItemIjkPlayerView) findViewById(R.id.DetailHot_ijkPlay);
    }

    private void initEvent() {
        //返回
        backCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
        //喜欢
        likeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (likeCheckBox.isChecked()){
                        likeCheckBox.setBackgroundResource(R.mipmap.hot_like1);
                        likeCheckBox.setEnabled(false);
                        unlikeCheckBox.setEnabled(false);
                    }

            }
        });
        //不喜欢
        unlikeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (unlikeCheckBox.isChecked()){
                    unlikeCheckBox.setBackgroundResource(R.mipmap.hot_unlike1);
                    likeCheckBox.setEnabled(false);
                    unlikeCheckBox.setEnabled(false);
                }else {

                }
            }
        });

        downCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

    @Override
    protected void onDestroy() {
        if (mPlayerView!=null){
            mPlayerView.onDestroy();
        }
        super.onDestroy();
    }

    private void initIjkPlay() {
        mPlayerView.setOnPlayCircleClickListener(this);
        mPlayerView.init(false);
        mPlayerView.mPlayerThumb.setActualImageResource(R.mipmap.bg1);
    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        if (mPlayerView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onPause() {
        if(mPlayerView!=null){
            mPlayerView.onPause();
        }
        super.onPause();
    }
    @Override
    public void onPlayCircleClicked() {
        mPlayerView.setTitle("这是个跑马灯TextView，标题要足够长才会跑。-(゜ -゜)つロ 乾杯~")
                //设置跳转进度
                .setSkipTip(1000*60*1)
                .enableDanmaku()
                //弹幕资源
                .setDanmakuSource(getResources().openRawResource(R.raw.bili))
//                .setVideoSource(null, null, VIDEO_HD_URL, null, null)
                //视频播放资源
                .setVideoSource(null, VIDEO_URL, VIDEO_HD_URL, null, null)
                //流畅、清晰、高清、超清和1080P对应0-4
                .setMediaQuality(IjkPlayerView.MEDIA_QUALITY_HIGH);

    }
}
