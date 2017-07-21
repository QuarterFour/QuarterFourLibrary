package com.a.quarter.view.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deleteFragnebt();

    }

    private void deleteFragnebt() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new RecommendFragment()).commit();
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        main_radioButton_recommend = (RadioButton) findViewById(R.id.main_radioButton_recommend);
        main_radioButton_episode = (RadioButton) findViewById(R.id.main_radioButton_episode);
        main_radioButton_video = (RadioButton) findViewById(R.id.main_radioButton_video);
        main_radioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
        main_radioGroup.setOnCheckedChangeListener(this);

    }

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
