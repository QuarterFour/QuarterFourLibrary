package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MyAdapterForRecommendFragment;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/20 21
 */

public class RecommendFragment extends Fragment {

    private TabLayout mTabLayout;
    private MyAdapterForRecommendFragment myAdapterForRecommendFragment;
    private RelativeLayout container;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recommendfragment_layout, container, false);


    }

    //tablayoutd
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTabLayout = (TabLayout) getView().findViewById(R.id.recommendFragemt_tab_layout);
        myAdapterForRecommendFragment = new MyAdapterForRecommendFragment(getActivity().getSupportFragmentManager());
        //设置tablayout标签getFragmentManager()
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));
        mTabLayout.addTab(mTabLayout.newTab().setText("关注"));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);


        //tablayout的切换监听实现点击切换推荐中的fragement，有些偷懒 看了几篇博客没有结果最后考虑先实现效果，前期先实现效果，后期找到更好的方法将其替换
        //我的思路是适配器控制fragment，适配器的getitem（）实例化fragment，并根据position切换
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.recommendFragemt_framlayout,myAdapterForRecommendFragment.getItem(position)).commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
