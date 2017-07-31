package com.a.quarter.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/30 20
 */

public class SetActivity extends BaseActivity implements View.OnClickListener {
    private Toolbar toolbar;


    //沉浸式
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setTitle("设置");
        setSupportActionBar(toolbar);
        //点击退出登陆
  findViewById(R.id.exit).setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.setactivity;
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(SetActivity.this,LoginActivity_OtherActivity.class);
        startActivity(intent);
    }
    //点击选项菜返回
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
