package com.example.dell.quarter.presenter;


import android.util.Log;
import android.widget.Toast;

import com.example.dell.quarter.modle.bean.LoginBean;
import com.example.dell.quarter.modle.http.HttpUtils;
import com.example.dell.quarter.modle.utils.Api;
import com.example.dell.quarter.view.activity.LoginActivity;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;

import java.util.HashMap;

/**
 * Created by dell on 2017/10/19.
 */

public class LoginPresenter extends BasePresenter implements RegisterInterfaceP_M{

     private LoginActivity loginActivity;
    private HttpUtils httpUtils;

    //无参构造
    public LoginPresenter(){
        httpUtils = new HttpUtils();
        httpUtils.onCallBack(this);
    }
    //逻辑判断
    public void loadLoginData(String phone, String mima) {
        HashMap<String,String> map=new HashMap<>();
        map.put("userPhone",phone);
        map.put("userPassword",mima);
        httpUtils.doPost(Api.Login,map, LoginBean.class);
    }
    //成功
    @Override
    public void onSuccess(Object o) {
        loginActivity.onSuccess(o);
    }
//失败
    @Override
    public void onError(Object o) {

    }
//关联
    public void setview(LoginActivity loginActivity) {
        this.loginActivity=loginActivity;
    }


}
