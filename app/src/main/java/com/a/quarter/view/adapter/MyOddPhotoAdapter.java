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
 * 类用途：
 * 思路：
 */

public class MyOddPhotoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> list = new ArrayList<>();
    private MyViewHoder myViewHoder;

    public MyOddPhotoAdapter(Context context) {
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

        if (convertView == null) {

            convertView = View.inflate(context, R.layout.frag_oddphoto, null);

            myViewHoder = new MyViewHoder();

            myViewHoder.head = (ImageView) convertView.findViewById(R.id.headimage_lv_oddp);
            myViewHoder.name = (TextView) convertView.findViewById(R.id.nametext_lv_oddp);
            myViewHoder.time = (TextView) convertView.findViewById(R.id.timetext_lv_oddp);
            myViewHoder.shrink = (ImageView) convertView.findViewById(R.id.shrinkimage_lv_oddp);
            myViewHoder.contenttext = (TextView) convertView.findViewById(R.id.contenttext_lv_oddp);
            myViewHoder.contentimage = (ImageView) convertView.findViewById(R.id.contentimage_oddp);
            myViewHoder.commentname = (TextView) convertView.findViewById(R.id.name_comment_oddp);
            myViewHoder.commentcontent = (TextView) convertView.findViewById(R.id.content_comment_oddp);

            convertView.setTag(myViewHoder);

        } else {
            myViewHoder = (MyViewHoder) convertView.getTag();
        }

//        Glide.with(context).load(list.get(position)).into(myViewHoder.head);
//        myViewHoder.name.setText(list.get(position));
//        myViewHoder.time.setText(list.get(position));
//        myViewHoder.contenttext.setText(list.get(position));
//        Glide.with(context).load(list.get(position)).into(myViewHoder.shrink);
//        Glide.with(context).load(list.get(position)).into(myViewHoder.contentimage);
//          myViewHoder.commentname.setText(list.get(position));
//          myViewHoder.commentcontent.setText(list.get(position));

        return convertView;
    }


    class MyViewHoder {

        ImageView head;
        TextView name;
        TextView time;

        ImageView shrink;
        TextView contenttext;
        ImageView contentimage;

        TextView commentname;
        TextView commentcontent;

    }

}
