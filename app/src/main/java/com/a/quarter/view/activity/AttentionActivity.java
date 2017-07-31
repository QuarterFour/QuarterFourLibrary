package com.a.quarter.view.activity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/31 11
 */

public class AttentionActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    private TabLayout mTabLayout;
    private Toolbar toolbar;

    @Override
    public Context context() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.attentionactivity_tab_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.daohang);
        toolbar.setTitle("我的关注");
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        mTabLayout.addTab(mTabLayout.newTab().setText("1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("3"));
        mTabLayout.addTab(mTabLayout.newTab().setText("4"));
        mTabLayout.addTab(mTabLayout.newTab().setText("5"));
        mTabLayout.addTab(mTabLayout.newTab().setText("6"));
        mTabLayout.addTab(mTabLayout.newTab().setText("7"));
        mTabLayout.addTab(mTabLayout.newTab().setText("8"));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.attentionactivity;
    }

    @Override
    protected void createPresenter() {

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

    //toolbar菜单的点击事件
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hotattention:
                Toast.makeText(this, "别急~莫凡哥哥在弄呢。。。", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    //加载 res/menu/toolbar.xml 文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.attentionactivity_menu, menu);
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
}
                               