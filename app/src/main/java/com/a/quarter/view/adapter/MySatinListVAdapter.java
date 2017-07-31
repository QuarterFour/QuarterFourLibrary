package com.a.quarter.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;

import java.util.ArrayList;
import java.util.List;

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


    /**
     * 上拉加载
     * 有接口后再做
     */
    public void addMore(List<String> lists,boolean isRefresh){

//
//        for (MenuInfo.ResultBean.DataBean data: lists) {
//            //将最新的数据添加到适配所定义的集合中
//
//            if(isRefresh) {
//                //isRefresh true 下拉的动作  要把数据添加到最前面
//                list.add(0, data);
//            }else {
//                //isRefresh false 上拉的动作  要把数据添加到最后面
//                list.add(data);
//            }
//
//        }


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
            myViewHoder.forward = (ImageView) convertView.findViewById(R.id.forwardimage_lv_sa);
            myViewHoder.comment = (ImageView) convertView.findViewById(R.id.commentimage_lv_sa);
            myViewHoder.like = (ImageView) convertView.findViewById(R.id.likeimage_lv_sa);

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

        /**
         * 点击“加号”图片其他三个显示或隐藏，并且解决图片显示错乱问题
         */
        myViewHoder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                myViewHoder.like.setVisibility(View.VISIBLE);
                myViewHoder.forward.setVisibility(View.VISIBLE);
                myViewHoder.comment.setVisibility(View.VISIBLE);

            }
        });




        return convertView;
    }


    /**
     * MyViewHoder
     */
    class MyViewHoder{

        ImageView head;
        ImageView edit;
        ImageView forward;
        ImageView like;
        ImageView comment;
        TextView name;
        TextView time;

    }

}
