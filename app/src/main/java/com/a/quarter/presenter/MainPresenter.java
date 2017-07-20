package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.MainView;

import io.reactivex.Observable;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public class MainPresenter extends BasePresenter<MainView> {




    public  void getData(String username){


        Observable<BaseBean<LoginBean>> login = Httputils.getApi().Login(username);
        Httputils.retrofitUtils(Httputils.getApi().Login(username), new BaseObserver<LoginBean>(context()) {
            @Override
            public void success(LoginBean loginBean) {

                getBaseview().CallBack(loginBean);

            }
        });


    }









}
