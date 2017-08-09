package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.bean.AttentionBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/8 14
 */

public class AttentionActivity_recycalviewAdapter extends RecyclerView.Adapter <AttentionActivity_recycalviewAdapter.MyHolder>{
    private  List<AttentionBean.UserBean> list=new ArrayList<>();
    private  Context contexts;
   public AttentionActivity_recycalviewAdapter(Context context){
       this.contexts=context;

   }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(contexts, R.layout.attentionacti_recy_layout, null);
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
    holder.name.setText(list.get(position).getUserName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyHolder extends RecyclerView.ViewHolder{

        private final TextView data;
        private final TextView name;
        private final ImageView im;

        public MyHolder(View itemView) {
            super(itemView);

            data = (TextView) itemView.findViewById(R.id.attentionacti_recy_layout_data);
            name = (TextView) itemView.findViewById(R.id.attentionacti_recy_layout_data);
            im = (ImageView) itemView.findViewById(R.id.attentionacti_recy_layout_im);
        }
    }

    public  void setdata(List<AttentionBean.UserBean> user){
        if (user!=null) {
            list.addAll(user);
        }
    }
}
