package com.example.dell.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;

import java.util.List;

/**
 * 视频
 * Created by dell on 2017/10/17.
 * 视频类
 */

public class VideoFragment extends Fragment{
    private TabLayout tab_FindFragment_title;                            //定义TabLayout
    private ViewPager vp_FindFragment_pager;                             //定义viewPager
    private FragmentPagerAdapter fAdapter;                               //定义adapter

    private List<Fragment> list_fragment;                                //定义要装fragment的列表
    private List<String> list_title;                                     //tab名称列表

    private VideoHotFragment videoHotFragment;              //热门fragment
    private VideoNearbyFragment videoNearbyFragment;            //附近fragment

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view=View.inflate(getActivity(), R.layout.videofragment_item,null);


        return view;
    }
}
