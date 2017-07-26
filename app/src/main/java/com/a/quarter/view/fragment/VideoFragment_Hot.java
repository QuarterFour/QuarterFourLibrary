package com.a.quarter.view.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.view.activity.DetailsVideoActivity;
import com.a.quarter.view.adapter.MyVideoRecyclerAdapter;

import java.util.HashMap;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/25
 * 类的作用:
 * 实现思路:
 */

public class VideoFragment_Hot extends Fragment {

    private RecyclerView video_recyclerView;
    private MyVideoRecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videofragment_hot, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        video_recyclerView = (RecyclerView) getActivity().findViewById(R.id.Video_RecyclerView);
        video_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyVideoRecyclerAdapter(getActivity());
        video_recyclerView.setAdapter(adapter);
        adapter.setOnItemClickLitener(new MyVideoRecyclerAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("This", "onItemClick: "+position );
                Intent intent = new Intent(getActivity(), DetailsVideoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.e("This", "onItemLongClick: "+position );
            }
        });
    }




}
