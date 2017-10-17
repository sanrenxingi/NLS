package com.example.dell.quarter.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by dell on 2017/10/17.
 */

public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        initView();
        initData();
    }
   abstract  int setViewId();

     abstract void initData();

     abstract void initView();
}
