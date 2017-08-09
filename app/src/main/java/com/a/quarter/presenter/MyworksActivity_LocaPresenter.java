package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.MyworksActivity_LocaBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.MyworksActivity_LocaView;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/7 21
 */

public class MyworksActivity_LocaPresenter extends BasePresenter<MyworksActivity_LocaView> {



public void getData(int id){
    Httputils.retrofitUtils(Httputils.getApi().Mywarks(id), new BaseObserver<MyworksActivity_LocaBean>(context()) {
        @Override
        public void success(MyworksActivity_LocaBean myworksActivity_locaBean) {
              getBaseview().callBack(myworksActivity_locaBean);
        }
    });

}
}
