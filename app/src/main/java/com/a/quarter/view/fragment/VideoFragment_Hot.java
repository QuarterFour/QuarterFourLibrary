package com.a.quarter.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;
import com.a.quarter.model.bean.HotVideoBean;
import com.a.quarter.presenter.HotPresenter;
import com.a.quarter.view.activity.DetailsHotVideoActivity;
import com.a.quarter.view.adapter.MyVideoHotAdapter;
import com.a.quarter.view.iview.HotFragmentView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/25
 * 类的作用:hot界面里的布局
 * 实现思路:
 */

public class VideoFragment_Hot extends Fragment implements HotFragmentView{

    private RecyclerView video_recyclerView;
    private MyVideoHotAdapter adapter;
    private HotPresenter presenter;
    private List<HotVideoBean.MediaBean> media = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.videofragment_hot, container, false);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }
//初始化控件
    private void initView() {
        presenter = new HotPresenter();
        presenter.setBaseview(this);
        video_recyclerView = (RecyclerView) getActivity().findViewById(R.id.VideoHot_RecyclerView);
        video_recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyVideoHotAdapter(getActivity());
        video_recyclerView.setAdapter(adapter);
        presenter.getData();
        adapter.setOnItemClickLitener(new MyVideoHotAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.e("This", "onItemClick: "+position );
                Intent intent = new Intent(getActivity(), DetailsHotVideoActivity.class);
                if (media!=null){
                    intent.putExtra("VideoSrc", (Serializable) media.get(position).getMediaSrc());



                }
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Log.e("This", "onItemLongClick: "+position );

            }
        });
    }


    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void CallBack(HotVideoBean hotBean) {
        media = hotBean.getMedia();
            adapter.getdata(media);

    }
}
