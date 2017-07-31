package com.a.quarter.view.activity;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.presenter.SiginPresenter;
import com.a.quarter.view.iview.SiginView;

public class SignActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener,SiginView, View.OnClickListener {
    private Toolbar toolbar;
    private TextInputEditText username;
    private TextInputEditText password;
    private TextInputEditText phonenumber;
    private TextInputEditText sex;
    private Button sigin;
    private SiginPresenter siginPresenter;

    //沉浸式
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

    public void initView() {
        //Toolbar相关
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        username = (TextInputEditText) findViewById(R.id.username);
        password = (TextInputEditText) findViewById(R.id.password);
        phonenumber = (TextInputEditText) findViewById(R.id.phonenumber);
        sex = (TextInputEditText) findViewById(R.id.sex);
        sigin = (Button) findViewById(R.id.siginactivity_button_sigin);
        sigin.setOnClickListener(this);

    }
    //toolbar的子菜单点击事件
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.have:
                finish();
                break;
        }
        return true;
    }
    //加载 res/menu/toolbar.xml 文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.snginactivity_menu, menu);
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
    //获取布局
    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign;
    }

    @Override
    protected void createPresenter() {
        siginPresenter = new SiginPresenter();
        siginPresenter.attach(this);

    }

    @Override
    public Context context() {
        return null;
    }
//回调请求的返回结果
    @Override
    public void CallBack(SiginBean siginBean) {

        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
//点击注册按钮
    @Override
    public void onClick(View v) {
        String numb = phonenumber.getText().toString();
        String name = username.getText().toString();
        String pwd = password.getText().toString();
        String sexs = sex.getText().toString();
        //点击调用注册接口
        siginPresenter.getData(numb,name,pwd,sexs);
    }
}