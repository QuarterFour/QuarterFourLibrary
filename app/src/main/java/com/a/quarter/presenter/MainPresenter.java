package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.system.Contant;
import com.a.quarter.view.iview.MainView;

import io.reactivex.Observable;

/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public class MainPresenter extends BasePresenter<MainView> {

    public  void getData(String username,String password,String userPhone,String userSex){

        Httputils.retrofitUtils(Httputils.getApi().sigin(username,password,userPhone,userSex),new BaseObserver<SiginBean>(context()) {

            @Override
            public void success(SiginBean siginBean) {
                getBaseview().CallBack(siginBean);
            }
        });


    }









}
