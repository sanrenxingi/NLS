package com.example.dell.quarter.presenter;

import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.modle.bean.VideoNearbyBean;
import com.example.dell.quarter.modle.http.HttpUtils;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.fragment.VideoNearbyFragment;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

/**
 * Created by dell on 2017/10/20.
 * 视频附近类
 */

public class VideoNearbyPresenter extends BasePresenter implements RegisterInterfaceP_M {
    private HttpUtils registerHttp;
    private VideoNearbyFragment view;


    //无参构造
    public VideoNearbyPresenter() {
        registerHttp = new HttpUtils();
        //与M层关联
        registerHttp.onCallBack(this);
    }

    public void loadviewNearbyData() {
        registerHttp.doVideoHotget(Api.VIDEONEARBY, VideoNearbyBean.class);
    }

    @Override
    public void onSuccess(Object o) {
     view.onSuccess(o);
    }

    @Override
    public void onError(Object o) {

    }


    public void attachView(VideoNearbyFragment view) {
      this.view=view;
    }


    public void dettachView() {
        this.view=null;
    }
}
