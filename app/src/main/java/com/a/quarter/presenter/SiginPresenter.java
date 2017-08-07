package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.system.Contant;
import com.a.quarter.view.iview.SiginView;

import io.reactivex.Observable;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/28 09
 */

public class SiginPresenter extends BasePresenter {
    private SiginView siginviews;

    public void attach(SiginView siginview) {
        this.siginviews = siginview;
    }


    public void getData(String username, String password, String userPhone, String userSex) {

        Httputils.retrofitUtils((Observable<SiginBean>) Httputils.getApi(Contant.SIGIN_URL).sigin(username, password, userPhone, userSex), new BaseObserver<SiginBean>(context()) {
            @Override
            public void success(SiginBean siginBean) {
                siginviews.CallBack(siginBean);
            }
        });
    }

}
