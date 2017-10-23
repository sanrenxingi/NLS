package com.example.dell.quarter.modle.utils;

import android.app.Application;

import com.example.dell.quarter.BuildConfig;
import com.example.dell.quarter.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

/**
 * Created by dell on 2017/10/19.
 */

public class App extends Application{
    private ImageLoader  mImageLoader;
    private UMShareAPI umShareAPI;

    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        umShareAPI = UMShareAPI.get(this);
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        init();
    }

    public UMShareAPI getUmShareAPI() {
        return umShareAPI;
    }

    private void init() {
            DisplayImageOptions options=new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .showImageOnLoading(R.mipmap.ic_launcher)
                    .build();

           ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                   .defaultDisplayImageOptions(options)
                   .build();

        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(con);

        }

    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }
}
