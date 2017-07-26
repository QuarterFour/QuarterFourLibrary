package com.a.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;

/**
 * 作者: 陈春晖
 * 时间: 2017/7/24
 * 类的作用:
 * 实现思路:
 */

public class MyVideoHotAdapter extends RecyclerView.Adapter<MyVideoHotAdapter.MyViewHolder> {
    private Context context;
    private OnItemClickLitener mOnItemClickLitener;

    public MyVideoHotAdapter(Context context) {
            this.context = context;
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
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
//             Uri uri= Uri.parse(Environment.getExternalStorageDirectory().getPath()+"/123.mp4");
//            holder.mVideoView.setVideoURI(uri);
        holder.mNameTextView.setText("-----Hot-----");
        holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        //通过getVideoThumbnail方法取得视频中的第一帧图片，该图片是一个bitmap对象
//        Bitmap bitmap=getVideoThumbnail("");
//将bitmap对象转换成drawable对象
//        Drawable drawable=new BitmapDrawable(bitmap);
//将drawable对象设置给视频播放窗口surfaceView控件作为背景图片
//        mVideoView.setBackgroundDrawable(drawable);
//            holder.mVideoView.setBackgroundDrawable(drawable);

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

        return 5;
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

//        private final IjkVideoView mVideoView;
//        private final AndroidMediaController mMediaController;
        private final TextView mNameTextView;
        private final ImageView mImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mNameTextView = (TextView) itemView.findViewById(R.id.Hot_NameTextView);
            mImageView = (ImageView) itemView.findViewById(R.id.Hot_MapImageView);
//            IjkMediaPlayer.loadLibrariesOnce(null);
//            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
//            mMediaController = new AndroidMediaController(context, false);
            //mMediaController.setSupportActionBar(actionBar);
//            mVideoView = (IjkVideoView) itemView.findViewById(R.id.Video_ijkPlay);
//            mVideoView.setMediaController(mMediaController);

        }
    }
//    public Bitmap getVideoThumbnail(String url) {
//        Bitmap bitmap = null;
////MediaMetadataRetriever 是android中定义好的一个类，提供了统一
////的接口，用于从输入的媒体文件中取得帧和元数据；
//        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
//        try {
//            //（）根据文件路径获取缩略图
////retriever.setDataSource(filePath);
//            retriever.setDataSource(url, new HashMap());
//            //获得第一帧图片
//            bitmap = retriever.getFrameAtTime();
//        }
//        catch(IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//        catch (RuntimeException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                retriever.release();
//            }
//            catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//        }
//        Log.v("bitmap", "bitmap="+bitmap);
//        return bitmap;
//    }

}
