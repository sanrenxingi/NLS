package com.example.dell.quarter.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.dell.quarter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 推荐界面
 * Created by dell on 2017/10/17.
 * 推荐
 */

public class RecommendFragment extends FatherFragment{

    List<String> list;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> arr;

    @Override
    protected void initView(View view) {
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.mtab);
    }

    @Override
    void inDate() {
        arr = new ArrayList<>();

        list = new ArrayList<>();
        tabLayout.addTab(tabLayout.newTab().setText("热门"));
        tabLayout.addTab(tabLayout.newTab().setText("关注"));
       arr.add(new RecommendHotFragment());
        arr.add(new RecommendAttentionFragment());
        list.add("热门");list.add("关注");
        tabLayout.setupWithViewPager(viewPager);
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

    @Override
    int inLayout() {
        return R.layout.fragment_recommend;
    }
}
