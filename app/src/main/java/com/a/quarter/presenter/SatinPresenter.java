package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.DisplayBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.SatinView;

import io.reactivex.Observable;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/26
 * 类用途：
 * 思路：
 */

public class SatinPresenter extends BasePresenter<SatinView> {

    public void getDisplayData() {

        Observable<DisplayBean> data = Httputils.getApi().getData();

        Httputils.retrofitUtils(data, new BaseObserver<DisplayBean>(context()) {
            @Override
            public void success(DisplayBean displayBean) {
                getBaseview().getDisplaySatin(displayBean);
            }
        });




    }
}
