package com.example.dell.quarter.presenter;

import android.util.Log;

import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.modle.http.HttpUtils;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.fragment.VideoHotFragment;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

/**
 * Created by dell on 2017/10/19.
 * 视频热门的P层
 * 聂雁宾
 */

public class VideoHotPresenter extends BasePresenter implements RegisterInterfaceP_M{
    private  HttpUtils registerHttp;
    private VideoHotFragment view;

    //无参构造
    public VideoHotPresenter() {
        registerHttp = new HttpUtils();
        //与M层关联
        registerHttp.onCallBack(this);
    }
     //逻辑操作方法
    public void loadVideoHotData() {
    registerHttp.doVideoHotget(Api.VIDEOHOT, VideoHotBean.class);
    }
    //成功
    @Override
    public void onSuccess(Object o) {
      VideoHotBean videoHotBean= (VideoHotBean) o;
        view.onSuccess(o);
    }
  //失败
    @Override
    public void onError(Object o) {

    }
   //与V层关联

    public void attachView(VideoHotFragment view) {
        this.view=view;
    }
    public void dettachView() {
        this.view=null;

    }
}
