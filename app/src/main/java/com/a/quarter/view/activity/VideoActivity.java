package com.a.quarter.view.activity;

import android.content.Context;

import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.VideoPresenter;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/26
 * 类用途：
 * 思路：
 */

public class VideoActivity extends BaseActivity<VideoPresenter> {
    @Override
    public Context context() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        ///R.layout.activity_video
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {

    }
}
