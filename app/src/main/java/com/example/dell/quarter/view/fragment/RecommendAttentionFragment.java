package com.example.dell.quarter.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.adapter.RecommendAttentionAdapter;

/**
 * 类描述：推荐下的关注界面fragment
 * 姓名 ：刘希鑫
 */

public class RecommendAttentionFragment extends FatherFragment{

    private RecyclerView recyclerView;

    @Override
    protected void initView(View view) {
        recyclerView = view.findViewById(R.id.recommend_attent_recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecommendAttentionAdapter adapter=new RecommendAttentionAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    void inDate() {

    }

    @Override
    int inLayout() {
        return R.layout.fragment_recommend_attention;
    }
}
