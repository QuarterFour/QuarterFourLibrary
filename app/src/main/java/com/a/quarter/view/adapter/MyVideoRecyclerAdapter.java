package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/24
 * 类的作用:
 * 实现思路:
 */

public class MyVideoRecyclerAdapter extends RecyclerView.Adapter<MyVideoRecyclerAdapter.MyViewHolder> {
    private Context context;

    public MyVideoRecyclerAdapter(Context context) {
            this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_recyclerview_item, null);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


    }



    @Override
    public int getItemCount() {

        return 0;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }
    }
}
