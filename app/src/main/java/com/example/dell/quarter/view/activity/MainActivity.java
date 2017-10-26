package com.example.dell.quarter.view.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.fragment.CrossTalkFragment;
import com.example.dell.quarter.view.fragment.RecommendFragment;
import com.example.dell.quarter.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * 首页
 * 作者  聂雁宾
 */
public class MainActivity extends AppCompatActivity {
    private ImageView touxiangimg;

    private SlidingMenu menu;
    private BottomTabBar bottomTabBar;
    private RelativeLayout rl;
    private ImageView chuangzuoimg;
    private View night;
    private String name;
    private String img;
    private ImageView side_imageview;
    private TextView side_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        img = intent.getStringExtra("img");
        Log.e("dasdadadada","dasdadadadsad"+name);
        Log.e("dasdadadada","dasdadadadsad"+img);
        //初始化数据
        initview();
        initData();
        //底部导航栏
        initbtn();
        //侧滑
        initMenu();
        //头像点击侧滑
        touxiangimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });
    }

    private void initMenu() {
//设置从哪里滑出
        menu.setMode(SlidingMenu.LEFT);
        //设置模式,不允许侧滑
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setShadowWidthRes(R.dimen.du);
        menu.setBehindOffsetRes(R.dimen.du);
        //设置渐入渐出的效果
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.slidingmenu_layout);
        rl= menu.findViewById(R.id.rl);
        night = menu.findViewById(R.id.sice_night_mode);
        side_imageview = menu.findViewById(R.id.side_imageview);
        side_name = menu.findViewById(R.id.side_name);
        //重新赋值
        side_name.setText(name);
        ImageLoader.getInstance().displayImage(img,side_imageview);
//        ImageLoader.getInstance().displayImage(img,touxiangimg);
        //点击出现登录页面
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,LoginMainActivity.class);
                startActivity(in);
            }
        });
        //日夜间切换
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sha=getSharedPreferences("name",MODE_PRIVATE);
                boolean  isNight=sha.getBoolean("night",false);
                if (isNight){
                    //白天模式

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    sha.edit().putBoolean("night",false).commit();
//                    bu.setText("切换到夜间模式");
                }else{

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    sha.edit().putBoolean("night",true).commit();
//                    bu.setText("切换到白天模式");
                }
                recreate();//最后的这个绝对不能忘，不然切换回失效的
            }
        });
    }

    private void initData() {
        menu = new SlidingMenu(this);
        initbtn();
    }

    private void initview() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        touxiangimg = (ImageView) findViewById(R.id.touxiangimg);
        chuangzuoimg = (ImageView) findViewById(R.id.chuangzuoimg);
        chuangzuoimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initbtn() {

        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.tuijian_select, R.mipmap.tuijian_default, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.duanzi_select, R.mipmap.duanzi_default, CrossTalkFragment.class)
                .addTabItem("视频", R.mipmap.video_select, R.mipmap.video_defaults, VideoFragment.class);

    }








}