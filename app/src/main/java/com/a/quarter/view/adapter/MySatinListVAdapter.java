package com.a.quarter.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/24
 * 类用途：段子的listview适配器
 * 思路：
 */

public class MySatinListVAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list = new ArrayList();
    private MyViewHoder myViewHoder;

    public MySatinListVAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){

            convertView=View.inflate(context,R.layout.frag_satin,null);

            myViewHoder = new MyViewHoder();

            myViewHoder.head = (ImageView) convertView.findViewById(R.id.headimage_lv_sa);
            myViewHoder.name = (TextView) convertView.findViewById(R.id.nametext_lv_sa);
            myViewHoder.time = (TextView) convertView.findViewById(R.id.timetext_lv_sa);
            myViewHoder.edit = (ImageView) convertView.findViewById(R.id.editimage_lv_sa);

            convertView.setTag(myViewHoder);
        }else {
            myViewHoder = (MyViewHoder) convertView.getTag();

        }

        /**
         * 现在没有数据，先注释下面的，等有bean类之后，再解封。
         */
//        Glide.with(context).load(list.get(position)).into(myViewHoder.head);
//        myViewHoder.name.setText(list.get(position));
//        myViewHoder.time.setText(list.get(position));
//        Glide.with(context).load(list.get(position)).into(myViewHoder.edit);

        return convertView;
    }


    class MyViewHoder{

        ImageView head;
        ImageView edit;
        TextView name;
        TextView time;

    }

}
