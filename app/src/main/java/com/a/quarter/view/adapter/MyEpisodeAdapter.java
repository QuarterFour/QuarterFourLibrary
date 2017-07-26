package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a.quarter.view.fragment.Episode_OddphotosFragment;
import com.a.quarter.view.fragment.Episode_SatinFragment;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/22
 * 类用途：
 * 思路：
 */

public class MyEpisodeAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<Fragment> list = new ArrayList<>();

    public MyEpisodeAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    public MyEpisodeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                return new Episode_SatinFragment();


            case 1:

                return new Episode_OddphotosFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }
}
