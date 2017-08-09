package com.a.quarter.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.model.bean.MyworksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/7 21
 */

public class MyworksAdapter extends RecyclerView.Adapter<MyworksAdapter.MyHolder> {

    private  List<MyworksBean.CommentListBean> list=new ArrayList<>();

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public MyHolder(View itemView) {
            super(itemView);
        }
    }

    public  void setdata(List<MyworksBean.CommentListBean> commentList){
        if (commentList!=null) {
            list.addAll(commentList);
        }
    }
}
