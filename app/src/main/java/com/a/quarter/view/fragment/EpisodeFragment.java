package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MySatinListVAdapter;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;

import java.util.ArrayList;


/**
 * 类的作用：段子的
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 09
 */

public class EpisodeFragment extends Fragment implements View.OnClickListener{

    private RadioGroup radio_group;
    private RadioButton satin;
    private RadioButton odd_photos;
    private LinearLayout lin;
    private ArrayList<Fragment> fragments;
    private Episode_SatinFragment episode_satinFragment;
    private TabLayout satin_tab;
    private MySatinListVAdapter satinListVAdapter;
    private ListView list_view;
    private ArrayList<String> arr;
    private SwipeRefreshLayout swip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        TextView satin_tab = (TextView) view.findViewById(R.id.satin);
        list_view = (ListView) view.findViewById(R.id.list_view);

        final PullToRefreshLayout pullToRefreshLayout = (PullToRefreshLayout) view.findViewById(R.id.pull_to_re);


        pullToRefreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束刷新
                        pullToRefreshLayout.finishRefresh();
                    }
                }, 2000);
            }

            @Override
            public void loadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 结束加载更多
                        pullToRefreshLayout.finishLoadMore();
                    }
                }, 2000);
            }
        });









//        swip = (SwipeRefreshLayout) view.findViewById(R.id.swip);
//
//        swip.setOnRefreshListener(this);
//        //设置下拉刷新进度条的颜色
//        swip.setColorSchemeResources(R.color.blue,R.color.red,R.color.purple);
//        //设置可加载更多
////        swip.setOn

        initData();
    }

    private void initData() {


        satinListVAdapter = new MySatinListVAdapter(getActivity());

        arr = new ArrayList<>();

        list_view.setAdapter(satinListVAdapter);


    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){



        }



    }

//    @Override
//    public void onRefresh() {
//
//        Toast.makeText(getActivity(), "刷新数据了>_<", Toast.LENGTH_SHORT).show();
//
//
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(2000);
//                    getActivity().runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            swip.setRefreshing(false);
//                        }
//                    });
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }.start();
//
//
//    }
}