package com.a.quarter.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import media.AndroidMediaController;
import media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import com.a.quarter.R;;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/26
 * 类的作用:
 * 实现思路:
 */

public class DetailsHotVideoActivity extends Activity{

    private IjkVideoView mVideoView;
    private AndroidMediaController mMediaController;
    private boolean mBackPressed;
    private String videoSrc;
    private CheckBox backCheckBox;
    private CheckBox likeCheckBox;
    private CheckBox unlikeCheckBox;
    private CheckBox downCheckBox;
//    private LinearLayout writeLinear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_hot_details);
        initDate();
        initView();
        initIjkPlay();
        initEvent();
    }

    private void initDate() {
        Intent intent = getIntent();
        videoSrc = intent.getStringExtra("VideoSrc");
    }

    private void initView() {
        backCheckBox = (CheckBox) findViewById(R.id.Detail_Back);
        likeCheckBox = (CheckBox) findViewById(R.id.Detail_like);
        unlikeCheckBox = (CheckBox) findViewById(R.id.Detail_unlike);
        downCheckBox = (CheckBox) findViewById(R.id.Detail_down);
//        writeLinear = (LinearLayout) findViewById(R.id.Detail_writeLinear);
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
                        likeCheckBox.setBackgroundResource(R.drawable.like);
                    }else {
                        likeCheckBox.setBackgroundResource(R.drawable.like1);
                    }


            }
        });
        //不喜欢
        unlikeCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (unlikeCheckBox.isChecked()){
                    unlikeCheckBox.setBackgroundResource(R.drawable.unlike);
                }else {
                    unlikeCheckBox.setBackgroundResource(R.drawable.unlike1);
                }
            }
        });

        downCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //写评论
//        writeLinear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        mVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.start();
            }
        });

    }

    private void initIjkPlay() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mMediaController = new AndroidMediaController(this, false);

        mVideoView = (IjkVideoView) findViewById(R.id.DetailsHot_ijkPlay);
        mVideoView.setMediaController(mMediaController);

        mVideoView.setVideoPath(videoSrc);
//        mVideoView.start();
//        Uri uri= Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/123.mp4");
//        mVideoView.setVideoURI(uri);


    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        super.onBackPressed();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBackPressed || !mVideoView.isBackgroundPlayEnabled()) {
            mVideoView.stopPlayback();
            mVideoView.release(true);
            mVideoView.stopBackgroundPlay();
        } else {
            mVideoView.enterBackground();
        }
        IjkMediaPlayer.native_profileEnd();

    }

}
