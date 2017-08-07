package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.HotBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.Recommend_HotFragmentView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/1 16
 */

public class Reco_HotFragment_Prasenter extends BasePresenter<Recommend_HotFragmentView> {


    public  void getData(){
        Httputils.retrofitUtils(Httputils.getApi().gethot(), new BaseObserver<HotBean>(context()) {

            @Override
            public void success(HotBean hotBean) {
                 getBaseview().CallBack(hotBean);
            }
        });
    }

    }


