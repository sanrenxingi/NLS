package com.example.dell.quarter.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.modle.bean.VideoNearbyBean;
import com.example.dell.quarter.presenter.VideoNearbyPresenter;
import com.example.dell.quarter.view.adapter.VideoHotAdapter;
import com.example.dell.quarter.view.adapter.VideoNearbyAdapter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

/**
 * Created by dell on 2017/10/18.
 * 视频中的附近
 * 作者：聂雁宾
 */

public class VideoNearbyFragment extends FatherFragment implements RegisterInterfaceP_V{
    private RecyclerView rv;
    private VideoNearbyPresenter videoNearbyPresenter;
    private VideoNearbyAdapter ad;

    @Nullable
    //找ID
    @Override
    protected void initView(View view) {
        rv = view.findViewById(R.id.rv);
        //将数据以瀑布流的形式展现
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
    }
//new数据
    @Override
    void inDate() {
        videoNearbyPresenter = new VideoNearbyPresenter();
        videoNearbyPresenter.loadviewNearbyData();
        videoNearbyPresenter.setview(this);
    }
//布局
    @Override
    int inLayout() {
        return R.layout.videohotfragment_item;
    }

    @Override
    public void onSuccess(Object o) {
        VideoNearbyBean videoNearbyBean= (VideoNearbyBean) o;
        //适配器
        ad=new VideoNearbyAdapter(getActivity(),videoNearbyBean.getData());
        rv.setAdapter(ad);
    }

    @Override
    public void onError(Object o) {

    }
}
