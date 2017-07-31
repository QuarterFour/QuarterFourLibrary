package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a.quarter.R;
import com.a.quarter.view.activity.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * 类的作用：
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 21
 */

public class RecommendFragment_HotFragment extends Fragment {

    private ArrayList<String> images;
    private Banner banner;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recommendfragment_hotfragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initView();
    }

    private void initData() {
        images = new ArrayList<>();
        images.add("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=c6b40ec8347adab43d851347bee49f2a/cc11728b4710b912f6514b1ec1fdfc03934522b9.jpg");
        images.add("http://pic31.nipic.com/20130715/11077942_162943728000_2.jpg");
        images.add("http://pic.58pic.com/58pic/14/61/42/51s58PICuGy_1024.jpg");
        images.add("http://pic25.nipic.com/20121209/11362722_211226245146_2.jpg");
        images.add("http://pic.58pic.com/58pic/12/02/22/45e58PICg3W.jpg");

    }

    private void initView() {
        banner = (Banner) getView().findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


}
