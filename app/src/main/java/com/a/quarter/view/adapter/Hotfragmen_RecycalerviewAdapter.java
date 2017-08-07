package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/8/1 17
 */

public class Hotfragmen_RecycalerviewAdapter extends RecyclerView.Adapter<Hotfragmen_RecycalerviewAdapter.Myholder> {

    private List<HotBean.ResourceBean> list = new ArrayList<>();
    private Context contexts;

    public Hotfragmen_RecycalerviewAdapter(Context context) {
        this.contexts = context;

    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(contexts, R.layout.hotfragmen_recycalerview_layout, null);
        Myholder myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(Myholder holder, int position) {
//        holder.name.setText(list.get(position).getName());
//        holder.title.setText(list.get(position).getContent());
//        holder.data.setText(list.get(position).getUptime());
        // TODO: 2017/8/1
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Myholder extends RecyclerView.ViewHolder {

        private final ImageView im;
        private final TextView data;
        private final TextView name;
        private final TextView title;

        public Myholder(View itemView) {
            super(itemView);
            im = (ImageView) itemView.findViewById(R.id.hotfra_recycal_layout_icon_image);
            data = (TextView) itemView.findViewById(R.id.hotfra_recycal_layout_data);
            name = (TextView) itemView.findViewById(R.id.hotfra_recycal_layout_name);
            title = (TextView) itemView.findViewById(R.id.hotfra_recycal_layout_title);

        }
    }

    public void setData(List<HotBean.ResourceBean> resource) {
        if (resource != null) {
            list.addAll(resource);
        }
    }
}
