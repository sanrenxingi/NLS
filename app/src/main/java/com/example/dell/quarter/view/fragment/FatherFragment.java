package com.example.dell.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public abstract class FatherFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int i = inLayout();
        View view =View.inflate(getActivity(),i,null);
        //查找控件id
        initView(view);
        inDate();
        return view;
    }
    //找到布局内的id
    protected abstract void initView(View view);

    //执行操作
     abstract void inDate();

    //传入布局：R.layout.xxxxx
     abstract int inLayout();

}
