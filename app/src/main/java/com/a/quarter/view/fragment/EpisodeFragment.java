package com.a.quarter.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.bean.DisplayBean;
import com.a.quarter.presenter.SatinPresenter;
import com.a.quarter.view.adapter.MySatinRecycleAdapter;
import com.a.quarter.view.iview.SatinView;

import java.util.ArrayList;
import java.util.List;


/**
 * 类的作用：段子的
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 09
 */

public class EpisodeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,SatinView {

    private MySatinRecycleAdapter satinRecycleAdapter;
    private ArrayList<String> arr;
    private SwipeRefreshLayout swip;
    private RecyclerView recycle;
    private SwipeRefreshLayout swip_refresh;
    private LinearLayoutManager linearLayoutManager;
    private TextView satin_tab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        satin_tab = (TextView) view.findViewById(R.id.satin);

        swip_refresh = (SwipeRefreshLayout) view.findViewById(R.id.swip_refresh);
        recycle = (RecyclerView) view.findViewById(R.id.recycle);

        initData();
    }

    private void initData() {

        SatinPresenter satinPresenter = new SatinPresenter();
        satinPresenter.setBaseview(this);
        satinPresenter.getDisplayData();

        arr = new ArrayList<>();


        satinRecycleAdapter = new MySatinRecycleAdapter(getActivity());

        recycle.setAdapter(satinRecycleAdapter);

        //线性布局
        linearLayoutManager = new LinearLayoutManager(getActivity());

        recycle.setLayoutManager(linearLayoutManager);

        swip_refresh.setOnRefreshListener(this);

        //上拉加载更多
        recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                if (dy > 0) {
                    //取决于你的瀑布流(recyclerView)用的什么样的布局
//                    int last = gridmanager.findLastVisibleItemPosition();
                    int last_grid = linearLayoutManager.findLastVisibleItemPosition();

                    if (last_grid + 1 == satinRecycleAdapter.getItemCount()) {


                        //进度条显示 加载数据
//                        bar.setVisibility(View.VISIBLE);

                        //加载数据
                        //省略

                        new Thread(){
                            @Override
                            public void run() {
                                super.run();

                                try {
                                    sleep(2000);
//                                    runOnUiThread(new Runnable() {
//                                        @Override
//                                        public void run() {
//                                            bar.setVisibility(View.GONE);
//                                        }
//                                    });

                                } catch (InterruptedException e) {
                                    e.printStackTrace();

                                }

                            }
                        }.start();




                    }
                }



            }
        });



    }


    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
////                ArrayList<String> arrayList = new ArrayList<>();
////                for (int i = 0; i < 10; i++) {
////                    int index = i+1;
////                    arrayList.add("")
////
////                }
//                swip_refresh.setRefreshing(false);
//                Toast.makeText(getActivity(), "更新了五条数据...", Toast.LENGTH_SHORT).show();
//            }
//        },3000);







    }


    @Override
    public Context context() {
        return getActivity();
    }

    @Override
    public void getDisplaySatin(DisplayBean displayBean) {

        List<DisplayBean.ResourceBean> resource = displayBean.getResource();
        satinRecycleAdapter.setCallBackDisplaySatin(resource);


    }
}