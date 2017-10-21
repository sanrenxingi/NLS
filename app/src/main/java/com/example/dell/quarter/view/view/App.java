package com.example.dell.quarter.view.view;

import android.app.Application;

import com.example.dell.quarter.BuildConfig;
import com.example.dell.quarter.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class App extends Application {
    private ImageLoader  mImageLoader;
    @Override
    public void onCreate() {

        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        DisplayImageOptions options=new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .build();
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(configuration);
    }


    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
