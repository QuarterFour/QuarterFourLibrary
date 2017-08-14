package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.SatinPraiseBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.SatinPraiseView;

import io.reactivex.Observable;

/**
 * 姓名：孙盼盼
 * 时间：2017/8/12
 * 类用途：段子点赞presenter
 * 思路：
 */

public class SatinPraisePresenter extends BasePresenter<SatinPraiseView> {

    public void getSatinPraiseBean(String nicekey){

        Observable<SatinPraiseBean> praiseNum = Httputils.getApi().getSatinPraise_num(nicekey);

        Httputils.retrofitUtils(praiseNum, new BaseObserver<SatinPraiseBean>(context()) {
            @Override
            public void success(SatinPraiseBean satinPraiseBean) {
                getBaseview().getCallBackSatinPraise(satinPraiseBean);
            }
        });


    }




}
