package com.a.quarter.view.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;

import com.a.quarter.R;
import com.a.quarter.model.media.AndroidMediaController;
import com.a.quarter.model.media.IjkVideoView;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/26
 * 类的作用:
 * 实现思路:
 */

public class DetailsAttentionVideoActivity extends Activity {

    private IjkVideoView mVideoView;
    private AndroidMediaController mMediaController;
    private boolean mBackPressed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_attention_details);
        initView();
        initEvent();
    }

    private void initEvent() {
        mVideoView.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {

                mVideoView.start();
            }
        });

    }

    private void initView() {
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        mMediaController = new AndroidMediaController(this, false);

        mVideoView = (IjkVideoView) findViewById(R.id.DetailsAttenton_ijkPlay);
        mVideoView.setMediaController(mMediaController);
        Uri uri= Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/123.mp4");
        mVideoView.setVideoURI(uri);

    }


    @Override
    protected void onStop() {
        super.onStop();
        mVideoView.release(true);
    }
}
