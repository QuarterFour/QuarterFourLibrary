package com.a.quarter.view.activity;


import android.content.Context;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.utils.LoadingDialogUtils;
import com.a.quarter.presenter.MainPresenter;
import com.a.quarter.ui.LoadingDialog;
import com.a.quarter.ui.Titanic;
import com.a.quarter.ui.TitanicTextView;
import com.a.quarter.view.iview.MainView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView {


    private Titanic titanic;
    private TitanicTextView myTitanicTextView;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void initData() {

    }
             
    @Override
    protected void initView() {
        myTitanicTextView = (TitanicTextView) findViewById(R.id.my_text_view);
        titanic = new Titanic();
        titanic.start(myTitanicTextView);

        LoadingDialogUtils.showDialog(MainActivity.this);




    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void createPresenter() {

        mPresenter=new MainPresenter();
    }


    @Override
    public Context context() {
        return this;
    }

    @Override
    public void CallBack(LoginBean loginBean) {

    }
}
