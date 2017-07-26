package com.a.quarter.model.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a.quarter.R;


/**
 * 作者：李亚雷
 * 时间：2017/7/17
 * 类用途：
 * 思路：
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {


    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //acticity跳转动画——右进左出
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init();
        initView();
        initData();

    }
    private void init() {

        createPresenter();//建立presenter
        if (mPresenter != null) {
            mPresenter.setBaseview(this);
        }
       // MyAppliction.getInstance().addActivity(this);//添加当前Activity
    }



    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();
    protected abstract void createPresenter();




    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        //        Presenter解除绑定
        if (mPresenter != null) {
            mPresenter.moveBaseview();
            mPresenter = null;
        }

       // MyAppliction.getInstance().delActivity(this);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




}
