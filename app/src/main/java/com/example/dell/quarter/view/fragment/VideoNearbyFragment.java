package com.example.dell.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;

/**
 * Created by dell on 2017/10/18.
 * 视频中的附近
 * 作者：聂雁宾
 */

public class VideoNearbyFragment extends FatherFragment{
    private RecyclerView rv;
    @Nullable
    //找ID
    @Override
    protected void initView(View view) {
        rv = view.findViewById(R.id.rv);
        
    }
//new数据
    @Override
    void inDate() {

    }
//布局
    @Override
    int inLayout() {
        return R.layout.videohotfragment_item;
    }
}
