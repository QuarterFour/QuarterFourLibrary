package com.a.quarter.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

/**
 * 作者：李亚雷
 * 时间：2017/7/17
 * 类用途：
 * 思路：
 */

public class MyAppliction extends Application {

    private static MyAppliction instance=new MyAppliction();
    private ArrayList<Activity> activities=new ArrayList<>();
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();

        activities = new ArrayList<>();
        mContext=this;
        Fresco.initialize(this);
    }
    public static synchronized MyAppliction getInstance() {

        return instance;
    }

    public void addActivity(Activity activity) {

        activities.add(activity);

    }

    public void delActivity(Activity activity) {

        activities.remove(activity);

    }


    public void exit() {

        for (Activity act : activities) {
            act.finish();
        }

        System.exit(0);

    }

    public static Context context() {
        return mContext;
    }

}
