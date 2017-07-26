package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MyEpisodeAdapter;
import com.a.quarter.view.adapter.MySatinListVAdapter;

import java.util.ArrayList;


/**
 * 类的作用：段子的
 * <p>
 * 作者： 宋莫凡
 * <p>
 * 思路：
 * <p>
 * on 2017/7/21 09
 */

public class EpisodeFragment extends Fragment implements View.OnClickListener{

    private RadioGroup radio_group;
    private RadioButton satin;
    private RadioButton odd_photos;
    private LinearLayout lin;
    private ArrayList<Fragment> fragments;
    private Episode_SatinFragment episode_satinFragment;
    private Episode_OddphotosFragment episode_oddphotosFragment;
    private TabLayout satin_tab;
    private MyEpisodeAdapter episodeAdapter;
    private MySatinListVAdapter satinListVAdapter;
    private ListView list_view;
    private ArrayList<String> arr;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView satin_tab = (TextView) view.findViewById(R.id.satin);
        list_view = (ListView) view.findViewById(R.id.list_view);

        //设置段子的两个title

        initData();
    }

    private void initData() {


        satinListVAdapter = new MySatinListVAdapter(getActivity());

        arr = new ArrayList<>();

        list_view.setAdapter(satinListVAdapter);



    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){



        }



    }
}