package com.a.quarter.view.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.presenter.SuccessPresenter;

/**
 * 姓名：孙盼盼
 * 时间：2017/7/31
 * 类用途：
 * 思路：
 */

public class SuccessActivity extends BaseActivity<SuccessPresenter> implements View.OnClickListener{


    private ImageView suc;
    private TextView ok;
    private ImageView qq_friend;
    private TextView qq_friend_text;
    private ImageView qqkl;
    private TextView qqkl_text;
    private ImageView friend_cricle;
    private TextView friend_cricle_text;
    private ImageView wechat;
    private TextView wechat_text;
    private Button button;

    @Override
    public Context context() {
        return this;
    }



    @Override
    protected void initView() {

        suc = (ImageView) findViewById(R.id.suc);
        ok = (TextView) findViewById(R.id.ok);

        //qq好友
        qq_friend = (ImageView) findViewById(R.id.qq_friend);
        qq_friend_text = (TextView) findViewById(R.id.qq_friend_text);

        //qq空间
        qqkl = (ImageView) findViewById(R.id.qqkl);
        qqkl_text = (TextView) findViewById(R.id.qqkl_text);

        //朋友圈
        friend_cricle = (ImageView) findViewById(R.id.friend_cricle);
        friend_cricle_text = (TextView) findViewById(R.id.friend_cricle_text);

        //微信
        wechat = (ImageView) findViewById(R.id.wechat);
        wechat_text = (TextView) findViewById(R.id.wechat_text);

        button = (Button) findViewById(R.id.button);

    }

    @Override
    protected void initData() {

        qq_friend.setOnClickListener(this);
        qqkl.setOnClickListener(this);
        friend_cricle.setOnClickListener(this);
        wechat.setOnClickListener(this);
        button.setOnClickListener(this);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_success;
    }

    @Override
    protected void createPresenter() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            //qq好友
            case R.id.qq_friend:

                break;

            //qq空间
            case R.id.qqkl:

                break;
            //朋友圈
            case R.id.friend_cricle:

                break;
            //微信
            case R.id.wechat:

                break;
            //button
            case R.id.button:

                Intent intent = new Intent(context(), MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }




    }
}
