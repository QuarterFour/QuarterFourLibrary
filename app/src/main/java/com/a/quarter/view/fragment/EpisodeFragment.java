package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a.quarter.R;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radio_group = (RadioGroup) view.findViewById(R.id.radio_group);
        satin = (RadioButton) view.findViewById(R.id.satin);
        odd_photos = (RadioButton) view.findViewById(R.id.odd_photos);
        lin = (LinearLayout) view.findViewById(R.id.lin);

        lin.setOnClickListener(this);
        satin.setOnClickListener(this);
        odd_photos.setOnClickListener(this);

        initData();
    }

    private void initData() {

        fragments = new ArrayList<>();
        episode_satinFragment = new Episode_SatinFragment();
        episode_oddphotosFragment = new Episode_OddphotosFragment();

        fragments.add(episode_satinFragment);
        fragments.add(episode_oddphotosFragment);

//        get

    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){




            case R.id.satin:




                Toast.makeText(getActivity(), "段子", Toast.LENGTH_SHORT).show();

                break;
            case R.id.odd_photos:
                Toast.makeText(getActivity(), "趣图", Toast.LENGTH_SHORT).show();
                break;

        }



    }
}