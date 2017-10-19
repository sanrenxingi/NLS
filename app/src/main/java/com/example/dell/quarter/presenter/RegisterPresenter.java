package com.example.dell.quarter.presenter;

import android.util.Log;

import com.example.dell.quarter.modle.bean.RegisterBean;
import com.example.dell.quarter.modle.http.HttpUtils;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.activity.RegisterActivity;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

import java.util.HashMap;

/**
 * Created by dell on 2017/10/17.
 */

public class RegisterPresenter extends BasePresenter implements RegisterInterfaceP_M<RegisterBean> {

    private final HttpUtils registerHttp;
    private RegisterActivity view;


    //无参构造
public RegisterPresenter(){
    registerHttp = new HttpUtils();
  registerHttp.onCallBack(this);
}
    //处理数据方法
    public void loadDataFromServer(HashMap<String,String> map) {
      registerHttp.doPost(Api.REGISTER,map, RegisterBean.class);
    }
//成功
    @Override
    public void onSuccess(RegisterBean registerBean) {
        Log.e("onSuccess","onSuccess"+registerBean.getCode());
        view.onSuccess(registerBean);

    }
//失败
    @Override
    public void onError(RegisterBean o) {

    }

    public void setview(RegisterActivity view) {
        this.view = view;
    }
}
