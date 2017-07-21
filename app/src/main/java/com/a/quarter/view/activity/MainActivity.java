package com.a.quarter.view.activity;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.presenter.MainPresenter;
import com.a.quarter.ui.LoadingDialog;
import com.a.quarter.ui.Titanic;
import com.a.quarter.ui.TitanicTextView;
import com.a.quarter.view.fragment.EpisodeFragment;
import com.a.quarter.view.fragment.RecommendFragment;
import com.a.quarter.view.fragment.VideoFragment;
import com.a.quarter.view.iview.MainView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, RadioGroup.OnCheckedChangeListener {


    private Titanic titanic;
    private TitanicTextView myTitanicTextView;
    private LoadingDialog mLoadingDialog;
    private FrameLayout main_framelayout;
    private RadioGroup main_radioGroup;
    private RadioButton main_radioButton_recommend;
    private RadioButton main_radioButton_episode;
    private RadioButton main_radioButton_video;
    private Toolbar too;
    private NavigationView anv_view;
    private DrawerLayout drawer_layout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void deleteFragnebt() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new RecommendFragment()).commit();
    }


    @Override
    protected void initData() {

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    protected void initView() {
        deleteFragnebt();
        //重要的两段代码
        too = (Toolbar) findViewById(R.id.toolbar);
        //替代ActionBar
        setSupportActionBar(too);
        main_radioButton_recommend = (RadioButton) findViewById(R.id.main_radioButton_recommend);
        main_radioButton_episode = (RadioButton) findViewById(R.id.main_radioButton_episode);
        main_radioButton_video = (RadioButton) findViewById(R.id.main_radioButton_video);
        main_radioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
        anv_view = (NavigationView) findViewById(R.id.anv_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        main_radioGroup.setOnCheckedChangeListener(this);
        anv_view.setCheckedItem(R.id.nac_call);//call为默认选中
//
//        ActionBar actionBar = getActionBar();
//        if (actionBar!=null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_goods_kefu);
//        }

        anv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              //  drawer_layout.closeDrawers();//关闭的方法

                return true;
            }
        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case  android.R.id.home:
//                drawer_layout.openDrawer(GravityCompat.START);
//                break;
//        }
//        return true;
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void createPresenter() {

        mPresenter = new MainPresenter();
    }


    @Override
    public Context context() {
        return this;
    }

    @Override
    public void CallBack(LoginBean loginBean) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {

            case R.id.main_radioButton_recommend:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new RecommendFragment()).commit();
                main_radioButton_recommend.setChecked(true);
                break;
            case R.id.main_radioButton_episode:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new EpisodeFragment()).commit();
                main_radioButton_episode.setChecked(true);
                break;
            case R.id.main_radioButton_video:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new VideoFragment()).commit();
                main_radioButton_video.setChecked(true);
                break;
        }
    }


}
