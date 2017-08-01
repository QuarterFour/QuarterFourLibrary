package com.a.quarter.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.view.iview.LoginView;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginView {

    private Toolbar toolbar;
    private TextView other;
    private Button qqlogin;
    private Button weixinlogin;

    @Override
    protected void initData() {

    }

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

    protected void initView() {
        other = (TextView) findViewById(R.id.other);
        //Toolbar相关
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        other.setOnClickListener(this);
        //微信登陆，qq登陆
        qqlogin = (Button) findViewById(R.id.main_qqlogin);
        weixinlogin = (Button) findViewById(R.id.main_weixinlogin);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void createPresenter() {


    }

    //点击选项菜单弹出侧滑
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    //点击其他登陆方式的点击事件
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, LoginActivity_OtherActivity.class);
        startActivity(intent);
    }

    @Override
    public Context context() {
        return this;
    }

    //接收回调回的数据
    @Override
    public void CallBack(LoginBean loginBean) {

    }
}
