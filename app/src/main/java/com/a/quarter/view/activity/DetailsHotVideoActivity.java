package com.a.quarter.view.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import media.AndroidMediaController;
import media.IjkVideoView;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import com.a.quarter.R;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_hot_details);
        initView();
        initIjkPlay();
        initEvent();
    }

    private void initView() {
        TextView backText= (TextView) findViewById(R.id.Detail_Back);
        TextView likeText = (TextView) findViewById(R.id.Detail_like);
        TextView unlikeText = (TextView) findViewById(R.id.Detail_unlike);
        TextView downText = (TextView) findViewById(R.id.Detail_down);
       LinearLayout writeLinear= (LinearLayout) findViewById(R.id.Detail_writeLinear);
    }

    private void initEvent() {
    mVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
        @Override
        public void onPrepared(IMediaPlayer iMediaPlayer) {

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
        Uri uri= Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/123.mp4");
        mVideoView.setVideoURI(uri);

    }

    @Override
    public void onBackPressed() {
        mBackPressed = true;
        super.onBackPressed();
    }



}
