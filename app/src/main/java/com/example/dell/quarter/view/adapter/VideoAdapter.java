package com.example.dell.quarter.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.dell.quarter.view.fragment.VideoHotFragment;
import com.example.dell.quarter.view.fragment.VideoNearbyFragment;

/**
 * Created by dell on 2017/10/19.
 *
 * 实现tablayout 和 viewpage 联动的Adapter
 * 聂雁宾
 */

public class VideoAdapter extends FragmentStatePagerAdapter {
    int nNumOfTabs;
    public VideoAdapter(FragmentManager fm, int nNumOfTabs) {
        super(fm);
        this.nNumOfTabs=nNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        //赋值
        switch(position)
        {
            case 0:
                VideoHotFragment tab1=new VideoHotFragment();
                return tab1;
            case 1:
                VideoNearbyFragment tab2=new VideoNearbyFragment();
                return tab2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return nNumOfTabs;
    }
}
