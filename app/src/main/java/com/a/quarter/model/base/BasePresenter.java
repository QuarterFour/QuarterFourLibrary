package com.a.quarter.model.base;

import android.content.Context;
import android.util.Log;

import com.a.quarter.system.MyAppliction;


/**
 * 作者：李亚雷
 * 时间：2017/7/18
 * 类用途：
 * 思路：
 */

public class BasePresenter<T extends BaseView> {

    private T baseview;


    public T getBaseview() {
        return baseview;
    }

    public void setBaseview(T baseview) {
        this.baseview = baseview;
    }


    public void moveBaseview() {
        this.baseview = null;
    }


    protected Context context() {

        if (baseview != null) {
            Log.e("This", "baseview.context(): "+baseview.context());
            return baseview.context();
        }
        Log.e("This", "MyAppliction.context(): "+MyAppliction.context());
        return MyAppliction.context();
    }

}
