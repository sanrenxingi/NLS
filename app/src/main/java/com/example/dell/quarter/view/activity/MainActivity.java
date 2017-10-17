package com.example.dell.quarter.view.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.fragment.CrossTalkFragment;
import com.example.dell.quarter.view.fragment.RecommendFragment;
import com.example.dell.quarter.view.fragment.VideoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

/**
 * 作者  聂雁宾
 */
public class MainActivity extends AppCompatActivity {

    private BottomTabBar  btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initview();
        initData();
        initbtn();

    }

    private void initData() {

    }

    private void initview() {
        btn =(BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }

    private void initbtn() {

        btn.init(getSupportFragmentManager())
                .addTabItem("推荐", R.mipmap.ic_launcher, RecommendFragment.class)
                .addTabItem("段子", R.mipmap.ic_launcher, CrossTalkFragment.class)
                .addTabItem("视频", R.mipmap.ic_launcher, VideoFragment.class);

    }
}
