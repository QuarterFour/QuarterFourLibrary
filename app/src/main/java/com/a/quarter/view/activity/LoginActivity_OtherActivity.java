package com.a.quarter.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.presenter.Login_otherPresenter;
import com.a.quarter.view.iview.LoginView;

public class LoginActivity_OtherActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,LoginView, View.OnClickListener {
    private Toolbar toolbar;
    private Button other_login;
    private Login_otherPresenter loginPresenter;
    private TextInputEditText userpassword;
    private TextInputEditText userphone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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

    @Override
    protected void initData() {

    }
    @Override
    protected  void initView() {

        userpassword = (TextInputEditText) findViewById(R.id.loginactivity_userpassword);
        userphone = (TextInputEditText) findViewById(R.id.loginactivity_userphone);
        other_login = (Button) findViewById(R.id.other_login);
        //Toolbar相关
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        other_login.setOnClickListener(this);
        findViewById(R.id.forget_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity_OtherActivity.this,FindPasswordActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login__other;
    }

    @Override
    protected void createPresenter() {
        loginPresenter = new Login_otherPresenter();
        loginPresenter.setBaseview(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign:
                Intent intent=new Intent(LoginActivity_OtherActivity.this,SignActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载 res/menu/toolbar.xml 文件
        getMenuInflater().inflate(R.menu.otheractivity_menu, menu);
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public Context context() {
        return this;
    }
//点击登录
    @Override
    public void onClick(View v) {
        String myUserPhone = userphone.getText().toString();
        String myUserPassword = userpassword.getText().toString();
        loginPresenter.getData(myUserPhone,myUserPassword);
    }
//返回数据
    @Override
    public void CallBack(LoginBean loginBean) {
        LoginBean.UserBean user = loginBean.getUser();
        Toast.makeText(this, "登陆成功"+user.getUserName(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(LoginActivity_OtherActivity.this,MainActivity.class);
        intent.putExtra("username",user.getUserName());
        intent.putExtra("usersex",user.getUserSex());
        startActivity(intent);
        finish();
    }
}