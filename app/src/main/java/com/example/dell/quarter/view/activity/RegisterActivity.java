package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.RegisterBean;
import com.example.dell.quarter.presenter.RegisterPresenter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

import java.util.HashMap;

/**
 * 聂雁宾
 * 注册页面
 */
public class RegisterActivity extends BaseActivity implements RegisterInterfaceP_V<RegisterBean> {

    private RegisterPresenter registerPresenter;
    private EditText etzh;
    private EditText etmm;
    private Button btn;
    private String phone;
    private String mima;
    private HashMap<String, String> map;
    private Object code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //注册的点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //逻辑判断方法
                phone = etzh.getText().toString();
                mima = etmm.getText().toString();
                if(phone.equals("")){
                    Toast.makeText(RegisterActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else if(mima.equals("")){
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if(!phone.equals("")&&!mima.equals("")){
                    byte[] bytes = phone.getBytes();
                    if(bytes.length==11){
                        map = new HashMap<>();
                        map.put("userPhone",phone);
                        map.put("userPassword",mima);
                        registerPresenter.loadDataFromServer(map);
                        registerPresenter.setview(RegisterActivity.this);
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this,"手机号不为11位，请重新输入",Toast.LENGTH_SHORT).show();
                        etzh.setText("");
                        etmm.setText("");
                    }

                }


            }
        });
    }

    @Override
    int setViewId() {
       return  R.layout.activity_register;
    }

    //new数据
    @Override
    void initData() {
        registerPresenter = new RegisterPresenter();
    }
//找ID
    @Override
    void initView() {
        etzh = findViewById(R.id.etzh);
        etmm = findViewById(R.id.etmm);
        btn = findViewById(R.id.btnzc);
    }

    @Override
    public void onSuccess(RegisterBean registerBean) {
        code = registerBean.getCode();

        if(code.equals("200")){
            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();


        } else{
            Toast.makeText(RegisterActivity.this,"手机号已被注册",Toast.LENGTH_SHORT).show();
        }
        Log.e("onSuccessonSuccess","onSuccessonSuccess"+ registerBean.getCode());
    }

    @Override
    public void onError(RegisterBean o) {

    }
}
