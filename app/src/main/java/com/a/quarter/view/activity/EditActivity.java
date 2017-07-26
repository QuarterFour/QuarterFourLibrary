package com.a.quarter.view.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.EditPresenter;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/25
 * 类用途：
 * 思路：
 */

public class EditActivity extends BaseActivity<EditPresenter> {


    private ImageView image1;
    private ImageView image2;
    private TextView textView1;
    private TextView textView2;

    @Override
    public Context context() {
        return this;
    }


    @Override
    protected void initView() {

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        textView1 = (TextView) findViewById(R.id.textview1);
        textView2 = (TextView) findViewById(R.id.textview2);

    }

    @Override
    protected void initData() {

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditActivity.this, "还没有资源哦！", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(EditActivity.this, VideoActivity.class);
//                startActivity(intent);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, SatinActivity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_edit;
    }

    @Override
    protected void createPresenter() {

    }
}
