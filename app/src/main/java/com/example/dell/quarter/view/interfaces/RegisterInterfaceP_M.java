package com.example.dell.quarter.view.interfaces;

/**
 * Created by dell on 2017/10/17.
 */

public interface RegisterInterfaceP_M<T>{
    void onSuccess(T t);
    void onError(int code,String str);
}
