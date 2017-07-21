package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;

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

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recommendfragment_layout,container,false);
        // TODO: 2017/7/20      
        
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mTabLayout = (TabLayout) getView().findViewById(R.id.recommendFragemt_tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));
        mTabLayout.addTab(mTabLayout.newTab().setText("关注"));



    }
}
