package com.example.dell.quarter.presenter;

import android.util.Log;

import com.example.dell.quarter.modle.bean.RegisterBean;
import com.example.dell.quarter.modle.http.RegisterHttp;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

import java.util.HashMap;

/**
 * Created by dell on 2017/10/17.
 */

public class RegisterPresenter extends BasePresenter implements RegisterInterfaceP_M<RegisterBean> {

    private final RegisterHttp registerHttp;


    //无参构造
public RegisterPresenter(){
    registerHttp = new RegisterHttp();
  registerHttp.onCallBack(this);
}
    //处理数据方法
    public void loadDataFromServer() {
        HashMap<String,String> map=new HashMap<>();
        map.put("userName","nyb");
        map.put("userPassword","nyb123");
        map.put("userPhone","17601627041");
        map.put("userSex","男");
      registerHttp.doPost(Api.URL,map, RegisterBean.class);
    }
//成功
    @Override
    public void onSuccess(RegisterBean registerBean) {
        Log.e("onSuccess","onSuccess"+registerBean.getCode());
    }
//失败
    @Override
    public void onError(int code, String str) {

    }
}
