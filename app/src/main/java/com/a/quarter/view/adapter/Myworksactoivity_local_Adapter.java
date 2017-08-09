package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.bean.MyworksActivity_LocaBean;
import com.bumptech.glide.Glide;

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

public class Myworksactoivity_local_Adapter extends RecyclerView.Adapter<Myworksactoivity_local_Adapter.MyHolder> {

    private List<MyworksActivity_LocaBean.ResourceBean> list = new ArrayList<>();
    private Context contexts;

    public Myworksactoivity_local_Adapter(Context context) {

        this.contexts=context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(contexts, R.layout.myworkactivity_local_rectcalview_layout,null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(contexts).load(list.get(position).getSrc()).into(holder.im);
        holder.name.setText(list.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private final ImageView im;
        private final TextView name;

        public MyHolder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.myworksactivity_local_recycal_im);
            name = (TextView) itemView.findViewById(R.id.myworksactivity_local_recycal_name);
        }


    }

    public void setdata(List<MyworksActivity_LocaBean.ResourceBean> resource) {
        if (resource != null) {
            list.addAll(resource);
        }
    }
}
