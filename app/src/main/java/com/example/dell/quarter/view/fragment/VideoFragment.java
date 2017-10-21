package com.example.dell.quarter.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.adapter.Find_tab_Adapter;
import com.example.dell.quarter.view.adapter.VideoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/10/17.
 * 视频类
 * 作者：聂雁宾
 */

public class VideoFragment extends FatherFragment{
    private TabLayout tabLayout;
    private ViewPager vp;
    private List<Fragment> arr=new ArrayList<>();
    List<String> list=new ArrayList<>();

//找ID
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void initView(View view) {
        //初始化数据

            tabLayout =  view.findViewById(R.id.tab);
            vp =  view.findViewById(R.id.vp);
            tabLayout.addTab(tabLayout.newTab().setText("热门"));
            tabLayout.addTab(tabLayout.newTab().setText("附近"));
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //tablayout联动viewpage
        VideoAdapter adapter=new VideoAdapter(getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
//new数据
    @Override
    void inDate() {


    }

    @Override
    int inLayout() {
        return  R.layout.videofragment_item;
    }


}

