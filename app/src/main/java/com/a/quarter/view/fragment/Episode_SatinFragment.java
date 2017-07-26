package com.a.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.a.quarter.R;
import com.a.quarter.view.adapter.MySatinListVAdapter;

import java.util.ArrayList;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/22
 * 类用途：段子的段子页面
 * 思路：
 */

public class Episode_SatinFragment extends Fragment {


    private ListView list_view;
    private MySatinListVAdapter satinListVAdapter;
    private ArrayList<String> arr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_satinfra, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list_view = (ListView) view.findViewById(R.id.list_view);

        initData();

    }

    private void initData() {

        satinListVAdapter = new MySatinListVAdapter(getActivity());

        arr = new ArrayList<>();

        list_view.setAdapter(satinListVAdapter);

    }


}
