package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MySatinListVAdapter;

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

    private LinearLayout lin;
    private TextView satin;
    private ListView listview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.episodefragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        satin = (TextView) view.findViewById(R.id.satin);
        listview = (ListView) view.findViewById(R.id.list_view);


        initData();

    }

    private void initData() {

        MySatinListVAdapter satinListVAdapter = new MySatinListVAdapter(getActivity());
        listview.setAdapter(satinListVAdapter);

    }


    @Override
    public void onClick(View v) {




    }
}