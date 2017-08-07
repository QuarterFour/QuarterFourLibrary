package com.a.quarter.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/2 12
 */

public class AttentionRecycalerview_Adapter extends RecyclerView.Adapter<AttentionRecycalerview_Adapter.MyHolder> {
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class MyHolder extends RecyclerView.ViewHolder{


        public MyHolder(View itemView) {
            super(itemView);
        }
    }
    public  void setData(){


    }
}
