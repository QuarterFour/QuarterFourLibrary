package com.a.quarter.view.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.view.adapter.MyAdapterForMessageActivity_Fragment;
import com.a.quarter.view.fragment.MessageActivity_MessageFragment;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/30 20
 */

public class MessageActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private MyAdapterForMessageActivity_Fragment myAdapterForMessageActivity_fragment;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deleteFragment();
    }

    private void deleteFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.messageactivity_framlayout,new MessageActivity_MessageFragment()).commit();
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
        toolbar.setTitle("消息通知");
        setSupportActionBar(toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.messageactivity_tab_layout);
        myAdapterForMessageActivity_fragment = new MyAdapterForMessageActivity_Fragment(getSupportFragmentManager());
        //设置tablayout标签getFragmentManager()
        mTabLayout.addTab(mTabLayout.newTab().setText("消息"));
        mTabLayout.addTab(mTabLayout.newTab().setText("私信"));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Toast.makeText(MessageActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.messageactivity_framlayout,myAdapterForMessageActivity_fragment.getItem(position)).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.messagesactivity;
    }

    @Override
    protected void createPresenter() {

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

}
