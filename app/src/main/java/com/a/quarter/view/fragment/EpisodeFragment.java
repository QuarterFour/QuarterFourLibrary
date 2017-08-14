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
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.bean.DisplayBean;
import com.a.quarter.model.bean.SatinCommentBean;
import com.a.quarter.model.bean.SatinPraiseBean;
import com.a.quarter.model.bean.SatinStepBean;
import com.a.quarter.presenter.SatinCommentPresenter;
import com.a.quarter.presenter.SatinPraisePresenter;
import com.a.quarter.presenter.SatinPresenter;
import com.a.quarter.presenter.SatinStepPresenter;
import com.a.quarter.view.adapter.MySatinRecycleAdapter;
import com.a.quarter.view.iview.SatinCommentView;
import com.a.quarter.view.iview.SatinPraiseView;
import com.a.quarter.view.iview.SatinStepView;
import com.a.quarter.view.iview.SatinView;

import java.util.List;


/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：段子里面的作者头像还没有弄好；还有内容还没有显示图片；上拉加载，
 *
 * 实现多个接口，分别是：显示段子；评论、踩、点赞、转发接口
 *
 */

public class EpisodeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, SatinView, SatinCommentView,SatinPraiseView,SatinStepView {

    private MySatinRecycleAdapter satinRecycleAdapter;
    private SwipeRefreshLayout swip;
    private RecyclerView recycle;
    private SwipeRefreshLayout swip_refresh;
    private LinearLayoutManager linearLayoutManager;
    private TextView satin_tab;
    private SatinPresenter satinPresenter;
    private boolean isrefrsh = false;
    private SatinStepPresenter satinStepPresenter;
    private SatinCommentPresenter satinCommentPresenter;
    private SatinPraisePresenter satinPraisePresenter;

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
        //线性布局
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recycle.setLayoutManager(linearLayoutManager);
        satinRecycleAdapter = new MySatinRecycleAdapter(getActivity());
        recycle.setAdapter(satinRecycleAdapter);
        swip_refresh.setOnRefreshListener(this);
        initData();
    }

    private void initData() {

        //显示段子的presenter
        satinPresenter = new SatinPresenter();
        satinPresenter.setBaseview(this);
        satinPresenter.getDisplayData();

        //段子“踩”数
        satinStepPresenter = new SatinStepPresenter();
        satinStepPresenter.setBaseview(this);

        SatinStepBean satinStepBean = new SatinStepBean();
        String character_bad_num = satinStepBean.getCharacter_bad_num();

        satinStepPresenter.getSatinStepData(character_bad_num);

//        //段子“评论”数
//        satinCommentPresenter = new SatinCommentPresenter();
//        satinCommentPresenter.setBaseview(this);
//        satinCommentPresenter.getSatinCommentData();

        //段子“点赞”数
        satinPraisePresenter = new SatinPraisePresenter();
        satinPraisePresenter.setBaseview(this);

        SatinPraiseBean satinPraiseBean = new SatinPraiseBean();
        String nice_num = satinPraiseBean.getNice_num();

        satinPraisePresenter.getSatinPraiseBean(nice_num);


        //段子 “转发” 数  还没有写，因为bean类没有弄好
//        SatinCommentPresenter satinCommentPresenter = new SatinCommentPresenter();
//        satinCommentPresenter.setBaseview(this);
//        satinCommentPresenter.getSatinCommentData();


        //上拉加载更多
        recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    //取决于你的瀑布流(recyclerView)用的什么样的布局
                    int last_grid = linearLayoutManager.findLastVisibleItemPosition();
                    if (last_grid + 1 == satinRecycleAdapter.getItemCount()) {


                    }
                }


            }
        });


    }


    /**
     * 下拉刷新，
     */
    @Override
    public void onRefresh() {


        satinPresenter.getDisplayData();

        isrefrsh = true;

    }


    @Override
    public Context context() {
        return getActivity();
    }

    /**
     * 回调显示段子的接口
     */
    @Override
    public void getDisplaySatin(DisplayBean displayBean) {

        List<DisplayBean.ResourceBean> resource = displayBean.getResource();
        satinRecycleAdapter.setCallBackDisplaySatin(resource);


        if (isrefrsh) {
            swip_refresh.setRefreshing(false);
            int size = resource.size();

            Toast.makeText(getActivity(), "刷新成功..."+size, Toast.LENGTH_SHORT).show();
            isrefrsh=false;
        }

    }


    /**
     * 回调段子  踩  数的
     */
    @Override
    public void getCallBackSatinStep(SatinStepBean satinStepBean) {

        String character_bad_num = satinStepBean.getCharacter_bad_num();
//        satinRecycleAdapter.set

    }


    /**
     * 回调段子  赞  数的
     */
    @Override
    public void getCallBackSatinPraise(SatinPraiseBean satinPraiseBean) {

        String nice_num = satinPraiseBean.getNice_num();



        satinRecycleAdapter.notifyDataSetChanged();




    }


    /**
     * 回调段子  评论  数的
     */
    @Override
    public void getCallBackSatinComment(SatinCommentBean satinCommentBean) {

    }
}