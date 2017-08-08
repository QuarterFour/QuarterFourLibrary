package com.a.quarter.presenter;



import com.a.quarter.model.base.BaseBean;
import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.HotVideoBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.system.Contant;
import com.a.quarter.view.iview.HotFragmentView;

import io.reactivex.Observable;

/**
 * 作者: 陈春晖
 * 时间: 2017/8/2
 * 类的作用:
 * 实现思路:
 */

public class HotPresenter extends BasePresenter<HotFragmentView> {


    public  void getData(){

    Httputils.retrofitUtils(Httputils.getApi().hot(), new BaseObserver<HotVideoBean>(context()) {
        @Override
        public void success(HotVideoBean hotBean) {
                    getBaseview().CallBack(hotBean);

        }
    });


    }



}
