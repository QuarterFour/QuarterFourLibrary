package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.bean.HotVideoBean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/24
 * 类的作用:
 * 实现思路:
 */

public class MyVideoHotAdapter extends RecyclerView.Adapter<MyVideoHotAdapter.MyViewHolder> {
    private Context context;
    private OnItemClickLitener mOnItemClickLitener;
    private List<HotVideoBean.MediaBean> media = new ArrayList<>();

    public MyVideoHotAdapter(Context context) {
            this.context = context;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



    public void getdata(List<HotVideoBean.MediaBean> media) {
        if (media!=null){
            this.media =media;
        }
        notifyDataSetChanged();
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.video_hot_item, null);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

//        holder.mNameTextView.setText(media.get(position).getMediaName() );
        Glide.with(context).load(media.get(position).getMediaPictureSrc()).into(holder.mImageView);

        if (mOnItemClickLitener != null)
        {
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);

                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {

        return media.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

//        private final IjkVideoView mVideoView;
//        private final AndroidMediaController mMediaController;
//        private final TextView mNameTextView;
        private final ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
//            mNameTextView = (TextView) itemView.findViewById(R.id.Hot_NameTextView);
            mImageView = (ImageView) itemView.findViewById(R.id.Hot_MapImageView);


        }
    }

}
