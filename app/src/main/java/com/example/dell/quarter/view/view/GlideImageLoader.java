package com.example.dell.quarter.view.view;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * 类描述：推荐下的热门界面无限轮播
 * 姓名 ：刘希鑫
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        App app = (App) context.getApplicationContext();
        app.getImageLoader().displayImage(path.toString(),imageView);
    }
}
