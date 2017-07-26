package com.a.quarter.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a.quarter.view.fragment.VideoFragment;
import com.a.quarter.view.fragment.VideoFragment_Attention;
import com.a.quarter.view.fragment.VideoFragment_Hot;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/25
 * 类的作用:
 * 实现思路:
 */

public class MyVideoFragment extends FragmentPagerAdapter {


    public MyVideoFragment(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new VideoFragment_Hot();
            case 1:
                return new VideoFragment_Attention();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
