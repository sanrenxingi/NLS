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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/10/17.
 * 视频类
 * 作者：聂雁宾
 */

public class VideoFragment extends FatherFragment{
    private TabLayout mtab;
    ViewPager viewPager;
    private List<Fragment> arr=new ArrayList<>();
    List<String> list=new ArrayList<>();

//找ID
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void initView(View view) {
        mtab =view.findViewById(R.id.mtab);
        viewPager =  view.findViewById(R.id.viewpager);
        mtab.addTab(mtab.newTab().setText("热门"));
        mtab.addTab(mtab.newTab().setText("附近"));
        arr.add(new VideoHotFragment());
        arr.add(new VideoNearbyFragment());
        mtab.setupWithViewPager(viewPager);
        list.add("热门");
        list.add("附近");
        viewPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return arr.get(position);
            }

            @Override
            public int getCount() {
                return arr.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
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

