package com.example.dell.quarter.view.fragment;

import android.view.View;

import com.example.dell.quarter.R;
import com.youth.banner.Banner;

/**
 * 类描述：推荐下的热门界面
 * 姓名 ：刘希鑫
 */

public class RecommendHotFragment extends FatherFragment{

    private Banner banner;

    @Override
    protected void initView(View view) {
        banner = view.findViewById(R.id.banner);

    }

    @Override
    void inDate() {

    }

    @Override
    int inLayout() {
        return R.layout.fragment_recommend_hot;
    }
}
