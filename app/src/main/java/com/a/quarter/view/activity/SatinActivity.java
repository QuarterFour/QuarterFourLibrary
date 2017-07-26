package com.a.quarter.view.activity;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.SatinPresenter;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/26
 * 类用途：
 * 思路：
 */

public class SatinActivity extends BaseActivity<SatinPresenter> implements View.OnClickListener{

    private TextView over;
    private TextView paa;
    private TextView publish;
    private EditText editText;
    private ImageView imageView;

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_satin;
    }

    @Override
    protected void initView() {

        over = (TextView) findViewById(R.id.over);
        paa = (TextView) findViewById(R.id.paa);
        publish = (TextView) findViewById(R.id.publish);

        editText = (EditText) findViewById(R.id.edit_edit);

        imageView = (ImageView) findViewById(R.id.add_pic);

        over.setOnClickListener(this);
        publish.setOnClickListener(this);
        editText.setOnClickListener(this);
        imageView.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.over:
                finish();
                break;
            case R.id.publish:
                Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_pic:
                Toast.makeText(this, "跳转到相册页面", Toast.LENGTH_SHORT).show();
                break;
        }




    }
}
