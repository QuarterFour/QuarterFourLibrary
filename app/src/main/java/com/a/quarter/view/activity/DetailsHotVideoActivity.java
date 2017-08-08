package com.a.quarter.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.a.quarter.R;

import media.AndroidMediaController;
import media.IjkVideoView;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

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
    private ImageView backImagView;
    private ImageView likeImageView;
    private ImageView unlikeImageView;
    private ImageView downImageView;
    private LinearLayout writeLinear;

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
        backImagView = (ImageView) findViewById(R.id.Detail_Back);
        likeImageView = (ImageView) findViewById(R.id.Detail_like);
        unlikeImageView = (ImageView) findViewById(R.id.Detail_unlike);
        downImageView = (ImageView) findViewById(R.id.Detail_down);
        writeLinear = (LinearLayout) findViewById(R.id.Detail_writeLinear);
    }

    private void initEvent() {
        //返回
        backImagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    finish();
            }
        });
        //喜欢
        likeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //不喜欢
        unlikeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        downImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //写评论
        writeLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

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
