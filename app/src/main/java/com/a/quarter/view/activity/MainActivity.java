package com.a.quarter.view.activity;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.a.quarter.R;
import com.a.quarter.model.base.BaseActivity;
import com.a.quarter.model.bean.LoginBean;
import com.a.quarter.model.bean.SiginBean;
import com.a.quarter.presenter.MainPresenter;
import com.a.quarter.ui.LoadingDialog;
import com.a.quarter.ui.Titanic;
import com.a.quarter.ui.TitanicTextView;
import com.a.quarter.view.fragment.EpisodeFragment;
import com.a.quarter.view.fragment.RecommendFragment;
import com.a.quarter.view.fragment.VideoFragment;
import com.a.quarter.view.iview.MainView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView, RadioGroup.OnCheckedChangeListener, Toolbar.OnMenuItemClickListener {


    private Titanic titanic;
    private TitanicTextView myTitanicTextView;
    private LoadingDialog mLoadingDialog;
    private FrameLayout main_framelayout;
    private RadioGroup main_radioGroup;
    private RadioButton main_radioButton_recommend;
    private RadioButton main_radioButton_episode;
    private RadioButton main_radioButton_video;
    private Toolbar mToolBar;
    private NavigationView anv_view;
    private DrawerLayout drawer_layout;
    private ActionMenuView mHomeAmv;
    private Intent intent;
    private String username;
    private String usersex;
    private boolean islogin;
    private SharedPreferences preferences;

    //初始化toolbar
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //登陆成功后返回用户名和性别
        preferences = getSharedPreferences("condition", MODE_PRIVATE);
        boolean islogin = preferences.getBoolean("islogin",false);
        if (islogin) {
            Intent intents = getIntent();
            username = intents.getStringExtra("username");
            usersex = intents.getStringExtra("usersex");
        } else {
            Toast.makeText(this, "您还没登陆，请去登陆", Toast.LENGTH_SHORT).show();
            Intent intents=new Intent(MainActivity.this,LoginActivity_OtherActivity.class);
            startActivity(intents);
        }



        initCreat();
        deleteFragnebt();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initCreat() {
        //-----toolbar----
        mToolBar = (Toolbar) findViewById(R.id.mToolBar);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationIcon(R.drawable.ugc_icon_attention);
        mToolBar.inflateMenu(R.menu.toolbar);
        mToolBar.setOnMenuItemClickListener(this);

    }

    //设置默认的fragment
    private void deleteFragnebt() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new RecommendFragment()).commit();
    }


    @Override
    protected void initData() {

    }
    @Override
    protected void initView() {
        main_radioButton_recommend = (RadioButton) findViewById(R.id.main_radioButton_recommend);
        main_radioButton_episode = (RadioButton) findViewById(R.id.main_radioButton_episode);
        main_radioButton_video = (RadioButton) findViewById(R.id.main_radioButton_video);
        main_radioGroup = (RadioGroup) findViewById(R.id.main_radioGroup);
        anv_view = (NavigationView) findViewById(R.id.anv_view);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        main_radioGroup.setOnCheckedChangeListener(this);
        anv_view.setCheckedItem(R.id.nav_care);//call为默认选中
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        //获得头像所在布局 与控件的点击事件（目前只有点击头像的，想找一个更简单的方法）
        View headerView = anv_view.getHeaderView(0);
        headerView.findViewById(R.id.icon_image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.closeDrawers();
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        //侧划列表条目的点击事件
        anv_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {



            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_care:
                        //Toast.makeText(MainActivity.this, "点击了 ：我的关注", Toast.LENGTH_SHORT).show();
                        intent=new Intent(MainActivity.this,AttentionActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_seek:
                       // Toast.makeText(MainActivity.this, "点击了 ：搜索好友", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,FindFrandActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_massage:
                        //Toast.makeText(MainActivity.this, "点击了 ：消息通知", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,MessageActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_myproduction:
                        //Toast.makeText(MainActivity.this, "点击了 ：我的作品", Toast.LENGTH_SHORT).show();
                      intent=new Intent(MainActivity.this,MyworksActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_set:
                      //  Toast.makeText(MainActivity.this, "点击了 ：设置", Toast.LENGTH_SHORT).show();
                        intent = new Intent(MainActivity.this,SetActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_night:
                        Toast.makeText(MainActivity.this, "点击了 ：夜间", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }


    //点击选项菜单弹出侧滑
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer_layout.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    //填充主步局
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //获得presenter
    @Override
    protected void createPresenter() {

    }

    @Override
    public Context context() {
        return this;
    }



    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {

            case R.id.main_radioButton_recommend:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new RecommendFragment()).commit();
                main_radioButton_recommend.setChecked(true);
                break;
            case R.id.main_radioButton_episode:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new EpisodeFragment()).commit();
                main_radioButton_episode.setChecked(true);
                break;
            case R.id.main_radioButton_video:
                getSupportFragmentManager().beginTransaction().replace(R.id.main_framelayout, new VideoFragment()).commit();
                main_radioButton_video.setChecked(true);
                break;
        }
    }
    //toolbar的子菜单的点击事件
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.compile:
                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //加载 res/menu/toolbar.xml 文件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
//沉浸式
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void CallBack(SiginBean siginBeann) {

    }
}
