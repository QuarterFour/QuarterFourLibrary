package com.a.quarter.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;
import com.a.quarter.view.activity.DetailsAttentionVideoActivity;
import com.a.quarter.view.adapter.MyVideoAttentionAdapter;


/**
 * 作者: 陈春晖
 * 时间: 2017/7/25
 * 类的作用:
 * 实现思路:
 */

public class VideoFragment_Attention extends Fragment {
    private RecyclerView video_recyclerView;
    private MyVideoAttentionAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videofragment_attention,container,false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            initView();
    }

    private void initView() {
        video_recyclerView = (RecyclerView) getActivity().findViewById(R.id.VideoAttention_RecyclerView);
        video_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
//        video_recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyVideoAttentionAdapter(getActivity());
        video_recyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new MyVideoAttentionAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DetailsAttentionVideoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

}
