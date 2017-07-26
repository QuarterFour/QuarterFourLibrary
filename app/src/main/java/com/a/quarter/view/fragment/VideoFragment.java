package com.a.quarter.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;

import com.a.quarter.view.adapter.MyVideoFragment;


/**
 * 类的作用：
 * <p>
 * 作者：陈春晖
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 09
 */

public class VideoFragment extends Fragment {

    private TabLayout mTabLayout;
    private MyVideoFragment mFragment;
    private VideoFragment_Hot hot;
    private VideoFragment_Attention attention;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videofragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //通过getVideoThumbnail方法取得视频中的第一帧图片，该图片是一个bitmap对象

        initFragment();
        initTabLayout();
        initView();
        initData();
    }

    private void initFragment() {
        hot = new VideoFragment_Hot();
        attention = new VideoFragment_Attention();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.VideoFragment_framlayout,hot);
        transaction.commit();
    }

    private void initTabLayout() {
        mTabLayout = (TabLayout) getView().findViewById(R.id.VideoFragment_tablayout);
        mFragment = new MyVideoFragment(getActivity().getSupportFragmentManager());
        //设置tablayout标签getFragmentManager()
        mTabLayout.addTab(mTabLayout.newTab().setText("热门"));
        mTabLayout.addTab(mTabLayout.newTab().setText("关注"));
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.VideoFragment_framlayout,mFragment.getItem(position)).commit();
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void initData() {

    }

    private void initView() {

    }
}