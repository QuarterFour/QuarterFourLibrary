package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.SatinStepBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.SatinStepView;

import io.reactivex.Observable;

/**
 * 姓名：孙盼盼
 * 时间：2017/8/12
 * 类用途：段子踩数
 * 思路：
 */

public class SatinStepPresenter extends BasePresenter<SatinStepView> {

    public void getSatinStepData(String badkey){

        Observable<SatinStepBean> step_num = Httputils.getApi().getStep_num(badkey);

        Httputils.retrofitUtils(step_num, new BaseObserver<SatinStepBean>(context()) {
            @Override
            public void success(SatinStepBean satinStepBean) {
                getBaseview().getCallBackSatinStep(satinStepBean);
            }
        });


    }



}
