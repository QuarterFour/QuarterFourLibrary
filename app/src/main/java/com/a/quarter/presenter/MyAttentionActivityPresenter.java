package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.AttentionBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.MyAttentionView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/2 11
 */

public class MyAttentionActivityPresenter extends BasePresenter<MyAttentionView> {

    public  void getData(int Userid){
        Httputils.retrofitUtils(Httputils.getApi().attention(Userid), new BaseObserver<AttentionBean>(context()) {
            @Override
            public void success(AttentionBean attentionBean) {
                getBaseview().callback(attentionBean);
            }
        });
    }
}
