package com.a.quarter.presenter;

import android.util.Log;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.SiginView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/28 09
 */

public class SiginPresenter extends BasePresenter<SiginView> {
    public void getData(String userName, String userPassword, String userPhone, String userSex) {
        Log.e( "getData: ","dddddddddd" );
        Httputils.retrofitUtils(Httputils.getApi().sigin(userName, userPassword, userPhone, userSex), new BaseObserver<SiginBean>(context()) {
            @Override
            public void success(SiginBean siginBean) {
               getBaseview().CallBack(siginBean);
            }
        });
    }
}
