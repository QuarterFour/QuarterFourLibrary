package com.a.quarter.view.fragment;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.bean.MyworksActivity_LocaBean;
import com.a.quarter.presenter.MyworksActivity_LocaPresenter;
import com.a.quarter.view.adapter.Myworksactoivity_local_Adapter;
import com.a.quarter.view.iview.MyworksActivity_LocaView;

import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 21
 */

public class MyworksActivity_LocalFragment extends BaseFragment implements MyworksActivity_LocaView {


    private RecyclerView recyclerView;
    private Myworksactoivity_local_Adapter adapter;
    private MyworksActivity_LocaPresenter presenter;

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.myworksactivity_local_recycal);
        GridLayoutManager gm = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(gm);
        adapter = new Myworksactoivity_local_Adapter(getActivity());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Toast.makeText(getActivity(), "onHiddenChanged", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {


        // TODO: 2017/8/7   BasePresenter
        presenter = new MyworksActivity_LocaPresenter();
        presenter.setBaseview(this);
        //发送网络请求  参数id
        presenter.getData(1);


    }

    @Override
    protected int setFragmentLayout() {
        return R.layout.myworksactivity_localfragment_layout;
    }

    @Override
    public Context context() {
        return getActivity();
    }


    //接口回调数据
    @Override
    public void callBack(MyworksActivity_LocaBean myworksActivity_locaBean) {
        List<MyworksActivity_LocaBean.ResourceBean> resource = myworksActivity_locaBean.getResource();
        adapter.setdata(resource);
        adapter.notifyDataSetChanged();


    }
}
