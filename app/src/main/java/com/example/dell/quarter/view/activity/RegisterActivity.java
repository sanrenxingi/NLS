package com.example.dell.quarter.view.activity;

import android.os.Bundle;

import com.example.dell.quarter.R;
import com.example.dell.quarter.presenter.RegisterPresenter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

public class RegisterActivity extends BaseActivity implements RegisterInterfaceP_V {

    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    int setViewId() {
       return  R.layout.activity_register;
    }

    //new数据
    @Override
    void initData() {
        registerPresenter = new RegisterPresenter();
        //逻辑判断方法
        registerPresenter.loadDataFromServer();
    }
//找ID
    @Override
    void initView() {

    }

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(int code, String str) {

    }
}
