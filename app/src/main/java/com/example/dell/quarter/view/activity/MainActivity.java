package com.example.dell.quarter.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.fragment.CrossTalkFragment;
import com.example.dell.quarter.view.fragment.RecommendFragment;
import com.example.dell.quarter.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 作者  聂雁宾
 */
public class MainActivity extends AppCompatActivity {
    private ImageView touxiangimg;

    private SlidingMenu menu;
    private BottomTabBar bottomTabBar;
    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
        initData();
        initbtn();
        //侧滑
        initMenu();

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
        //点击出现登录页面
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(MainActivity.this,LoginMainActivity.class);
                startActivity(in);
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


    }

    private void initbtn() {

        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.tuijian_select, R.mipmap.tuijian_default, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.duanzi_select, R.mipmap.duanzi_default, CrossTalkFragment.class)
                .addTabItem("视频", R.mipmap.video_select, R.mipmap.video_defaults, VideoFragment.class);

    }
}