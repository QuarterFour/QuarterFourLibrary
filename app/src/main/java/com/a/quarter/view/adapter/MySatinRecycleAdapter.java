package com.a.quarter.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.bean.DisplayBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/24
 * 类用途：段子的listview适配器
 * 思路：
 */

public class MySatinRecycleAdapter extends RecyclerView.Adapter<MySatinRecycleAdapter.MyViewHoder> {

    private Context context;
    private ArrayList<DisplayBean.ResourceBean> list = new ArrayList();


    public MySatinRecycleAdapter(Context context) {
        this.context = context;

    }


    /**
     * 上拉加载
     * 有接口后再做
     */

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.frag_satin, null);
        MyViewHoder myViewHoder = new MyViewHoder(inflate);

        return myViewHoder;
    }

    /**
     * 因为后台没有用户头像，所以先注释掉，用默认的。
     */
    @Override
    public void onBindViewHolder(final MyViewHoder holder, final int position) {

        //头像
//        Glide.with(context).load(list.get(position).getUser().getUserHead()).into(holder.head_image);
        //名字
        holder.name_text.setText(list.get(position).getUser().getUserName());
        //时间
        holder.time_text.setText(list.get(position).getUptime()+"");
        //评论
        holder.commentnum.setText(list.get(position).getCommentNum()+"");
        //转发
        holder.forwardnum.setText(list.get(position).getForwardNum()+"");
        //点赞
        holder.praisenum.setText(list.get(position).getNiceNum()+"");
        //内容
        holder.content_text.setText(list.get(position).getContent()+"");
        //图片_内容
        Glide.with(context).load(list.get(position).getSrc()).into(holder.image_content);

        //喜欢、转发和收藏的图片
        holder.edit_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //得到喜欢、转发和收藏的状态，判断是隐藏还是显示
                boolean isshow = list.get(position).isshow();

                if ( ! isshow) {
                    showShare(holder);
                } else {
                    disimisShare(holder);
                }


                if (isshow){

                    list.get(position).setIsshow(false);

                }else {
                    list.get(position).setIsshow(true);
                }


            }
        });

        showShareText(holder,list.get(position).isshow());


        //数量
//        commentnum
//        forwardnum
//        praisenum

        //评论
        holder.commentnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "你要评论吗？没问题，但现在还不可以哦！", Toast.LENGTH_SHORT).show();
            }
        });

        //转发
        holder.forwardnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "你要转发吗？没问题，但现在还不可以哦！", Toast.LENGTH_SHORT).show();
            }
        });


        //点赞---点击变红
        holder.praisenum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Drawable drawable1 = context.getResources().getDrawable(R.drawable.praise_ok);
                drawable1.setBounds(0,0,drawable1.getMinimumWidth(),drawable1.getMinimumHeight());

                holder.praisenum.setCompoundDrawables(null,drawable1,null,null);

            }
        });




    }

    //改变集合里面的状态
    private void showShareText(MyViewHoder holder , boolean isshow) {


        if (isshow){
            holder.commentnum.setVisibility(View.VISIBLE);
            holder.forwardnum.setVisibility(View.VISIBLE);
            holder.praisenum.setVisibility(View.VISIBLE);
        }else {
            holder.commentnum.setVisibility(View.INVISIBLE);
            holder.forwardnum.setVisibility(View.INVISIBLE);
            holder.praisenum.setVisibility(View.INVISIBLE);
        }



    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //图片动画（消失时）
    private void disimisShare(MyViewHoder holder) {


        showShareText(holder,false);

        startMyAnimation(100f, 0.0f, holder.commentnum);
        startMyAnimation(100f, 0.0f, holder.forwardnum);
        startMyAnimation(100f, 0.0f, holder.praisenum);
    }

    //图片动画（显示时）
    private void showShare(MyViewHoder holder) {

        showShareText(holder,true);
        startMyAnimation(0.0f, 1f, holder.commentnum);
        startMyAnimation(0.0f, 1f, holder.forwardnum);
        startMyAnimation(0.0f, 1f, holder.praisenum);
    }

    //动画开始时
    private void startMyAnimation(float start, float end, TextView edit_image) {

        AnimationSet animationSet = new AnimationSet(false);

        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 540f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);

//        new TranslateAnimation(100, Animation.RELATIVE_TO_PARENT,50,Animation.RELATIVE_TO_PARENT,)

        AlphaAnimation alphaAnimation = new AlphaAnimation(start, end);
        alphaAnimation.setDuration(2000);

        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotateAnimation);


        animationSet.setDuration(1000);
        edit_image.setAnimation(animationSet);
        edit_image.startAnimation(animationSet);
    }


    public void setCallBackDisplaySatin(List<DisplayBean.ResourceBean> resource) {

        if (resource != null) {
            this.list.clear();
            this.list = (ArrayList<DisplayBean.ResourceBean>) resource;
        }
        notifyDataSetChanged();
    }



    /**
     * MyViewHoder   1
     */
    class MyViewHoder extends RecyclerView.ViewHolder {

        private final ImageView head_image;
        private final TextView name_text;
        private final TextView time_text;
        private final TextView content_text;
        private final ImageView edit_image;
        private final TextView commentnum;
        private final TextView forwardnum;
        private final TextView praisenum;
        private final ImageView image_content;


        public MyViewHoder(View itemView) {
            super(itemView);

            head_image = (ImageView) itemView.findViewById(R.id.headimage_lv_sa);
            name_text = (TextView) itemView.findViewById(R.id.nametext_lv_sa);
            time_text = (TextView) itemView.findViewById(R.id.timetext_lv_sa);
            edit_image = (ImageView) itemView.findViewById(R.id.editimage_lv_sa);
            content_text = (TextView) itemView.findViewById(R.id.text_lv_sa);
            image_content = (ImageView) itemView.findViewById(R.id.image_content);

            //有动画的三个控件
            commentnum = (TextView) itemView.findViewById(R.id.commentnum);
            forwardnum = (TextView) itemView.findViewById(R.id.forwardnum);
            praisenum = (TextView) itemView.findViewById(R.id.praisenum);


        }
    }


}
