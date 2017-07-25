package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MyVideoRecyclerAdapter;

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

    private RecyclerView video_recyclerView;
    private MyVideoRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videofragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {
        video_recyclerView = (RecyclerView) getActivity().findViewById(R.id.Video_RecyclerView);
        video_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,
                StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyVideoRecyclerAdapter(getActivity());
        video_recyclerView.setAdapter(adapter);
    }
}