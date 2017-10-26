package com.example.dell.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.presenter.VideoHotPresenter;
import com.example.dell.quarter.view.adapter.VideoHotAdapter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

/**
 * Created by dell on 2017/10/18.
 * 视频中的热门类
 * 作者：聂雁宾
 */

public class VideoHotFragment extends FatherFragment implements RegisterInterfaceP_V{

    private RecyclerView rv;
    private VideoHotPresenter videoHotPresenter;
   private VideoHotAdapter ad;
    //找ID
    @Nullable
    @Override
    protected void initView(View view) {
        rv = view.findViewById(R.id.rv);
        //将数据以瀑布流的形式展现
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }

    @Override
    void inDate() {
        videoHotPresenter = new VideoHotPresenter();
        videoHotPresenter.loadVideoHotData();
        videoHotPresenter.attachView(this);
    }
//视图
    @Override
    int inLayout() {
        return R.layout.videohotfragment_item;
    }
//成功
    @Override
    public void onSuccess(Object o) {
        VideoHotBean videoHotBean= (VideoHotBean) o;
        ad=new VideoHotAdapter(getActivity(),videoHotBean.getData());
        rv.setAdapter(ad);

    }
//失败
    @Override
    public void onError(Object o) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoHotPresenter.dettachView();
    }
}
