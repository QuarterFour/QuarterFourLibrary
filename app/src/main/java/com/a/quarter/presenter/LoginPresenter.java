package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.LoginView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/28 19
 */

public class LoginPresenter extends BasePresenter {

    private LoginView loginViews;
    public  void attach(LoginView loginView){
        this.loginViews=loginView;
    }


    public  void getData( String password, String userPhone) {

        Httputils.retrofitUtils( Httputils.getApi().login(password,userPhone), new BaseObserver<LoginBean>(context()){
            @Override
            public void success(LoginBean loginBean) {
                loginViews.CallBack(loginBean);
            }
        });
    }

}
