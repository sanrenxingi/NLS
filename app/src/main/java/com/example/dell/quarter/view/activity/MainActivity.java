package com.example.dell.quarter.view.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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

    private BottomTabBar  btn;
    private ImageView touxiangimg;

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

            }
        });
    }
    private void initMenu() {
        SlidingMenu menu=new SlidingMenu(this);
//设置从哪里滑出
        menu.setMode(SlidingMenu.LEFT);

        //设置模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.du);
        menu.setBehindOffsetRes(R.dimen.du);
        //设置渐入渐出的效果
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
//        menu.setMenu(R.layout.item);

    }

    private void initData() {
        
    }
    private void initview() {
        btn =(BottomTabBar) findViewById(R.id.bottom_tab_bar);
        touxiangimg = (ImageView) findViewById(R.id.touxiangimg);
    }

    private void initbtn() {
        btn.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.ic_launcher, CrossTalkFragment.class)
                .addTabItem("视频", R.mipmap.ic_launcher, VideoFragment.class)
        ;


    }
}
