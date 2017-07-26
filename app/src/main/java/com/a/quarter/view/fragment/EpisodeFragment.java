package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MyEpisodeAdapter;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        satin_tab = (TabLayout) view.findViewById(R.id.satin_tab_layout);
        lin = (LinearLayout) view.findViewById(R.id.lin);

        //设置段子的两个title
        satin_tab.addTab(satin_tab.newTab().setText("段子"));
        satin_tab.addTab(satin_tab.newTab().setText("趣图"));

        satin_tab.setTabMode(TabLayout.MODE_FIXED);

        lin.setOnClickListener(this);

        initData();
    }

    private void initData() {

        fragments = new ArrayList<>();
        episode_satinFragment = new Episode_SatinFragment();
        episode_oddphotosFragment = new Episode_OddphotosFragment();

        fragments.add(episode_satinFragment);
        fragments.add(episode_oddphotosFragment);
        episodeAdapter = new MyEpisodeAdapter(getActivity().getSupportFragmentManager());

       setDefaultFragment();

        //TabLayout的监听
        satin_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.lin,episodeAdapter.getItem(position)).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    //设置默认显示的Fragment
    private void setDefaultFragment() {

        FragmentTransaction transaction = getActivity()
                .getSupportFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.lin,episodeAdapter.getItem(0)).commit();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.lin:
                Toast.makeText(getActivity(), "趣图", Toast.LENGTH_SHORT).show();
                break;

        }



    }
}