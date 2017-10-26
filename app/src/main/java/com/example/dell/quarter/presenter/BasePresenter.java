package com.example.dell.quarter.presenter;

import com.example.dell.quarter.view.interfaces.IMvpView;

/**
 * Created by dell on 2017/10/17.
 * P层的总类
 */

public class BasePresenter<T> {


    private T mt;

    public void attachView(T t) {
        //IMainView view = MainActivity
        this.mt = t;
    }

    public void dettachView() {
        this.mt = null;
    }
}
