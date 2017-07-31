package com.a.quarter.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a.quarter.view.fragment.MessageActivity_MessageFragment;
import com.a.quarter.view.fragment.MessageActivity_PrivacyMessageFragment;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 21
 */

public class MyAdapterForMessageActivity_Fragment extends FragmentPagerAdapter {


    public MyAdapterForMessageActivity_Fragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MessageActivity_MessageFragment();
            case 1:
                return new MessageActivity_PrivacyMessageFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
//    }
//
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
//    }
}
