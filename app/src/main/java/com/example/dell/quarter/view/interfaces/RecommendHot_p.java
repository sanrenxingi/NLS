package com.example.dell.quarter.view.interfaces;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public interface RecommendHot_p<T> {
    void onSuccess(T  t);
    void failure(int code,String str);
}
