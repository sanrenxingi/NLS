package com.example.dell.quarter.presenter;

import com.example.dell.quarter.modle.bean.CrossTalkBean;
import com.example.dell.quarter.modle.http.HttpUtils;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.fragment.CrossTalkFragment;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

import java.util.HashMap;

/**
 * 类用途：段子界面的P层
 * 作者：史曌宇
 */

public class CrossTalkPresenter extends BasePresenter implements RegisterInterfaceP_M<CrossTalkBean>{


    private HttpUtils httpUtils;
    private CrossTalkFragment crossTalkFragment;

    public  CrossTalkPresenter() {
        httpUtils = new HttpUtils();
        httpUtils.onCallBack(this);
    }

    @Override
    public void attachView(Object o) {
        super.attachView(o);

        crossTalkFragment = (CrossTalkFragment) o;
        loadCrossTalkData();
    }

    private void loadCrossTalkData() {
        HashMap<String,String> map=new HashMap<>();
        httpUtils.doGet(Api.Cross_Talk_URL, map, CrossTalkBean.class);
    }

    @Override
    public void dettachView() {
        super.dettachView();
        crossTalkFragment=null;
    }


    @Override
    public void onSuccess(CrossTalkBean crossTalkBean) {
        crossTalkFragment.onSuccess(crossTalkBean);
    }

    @Override
    public void onError(CrossTalkBean crossTalkBean) {

    }
}
