package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.LoginBean;
import com.example.dell.quarter.presenter.LoginPresenter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

import java.util.HashMap;

/**
 * 聂雁宾
 */
public class LoginActivity extends BaseActivity implements RegisterInterfaceP_V{

    private TextView zhuce;
    private Button btnlogin;
    private LoginPresenter loginPresenter;
    private EditText etzh;
    private EditText etmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册跳转
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //登录跳转
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = etzh.getText().toString();
                String mima = etmm.getText().toString();
                if(phone.equals("")){
                    Toast.makeText(LoginActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else if(mima.equals("")){
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if(!phone.equals("")&&!mima.equals("")){
                    byte[] bytes = phone.getBytes();
                    if(bytes.length==11){
                        loginPresenter.loadLoginData(phone,mima);
                        loginPresenter.setview(LoginActivity.this);
                    }else {
                        Toast.makeText(LoginActivity.this, "手机号不为11位，请重新输入", Toast.LENGTH_SHORT).show();
                        etzh.setText("");
                        etmm.setText("");
                    }

                }



            }
        });

    }

    @Override
    int setViewId() {
        return R.layout.activity_main;
    }

    //new数据
    @Override
    void initData() {
        loginPresenter = new LoginPresenter();
    }
     //找ID
    @Override
    void initView() {
        etmm = findViewById(R.id.loginetmm);
        etzh = findViewById(R.id.loginetzh);
        zhuce = findViewById(R.id.zhuce);
        btnlogin = findViewById(R.id.loginbtn);
    }

    @Override
    public void onSuccess(Object o) {
        LoginBean loginBean= (LoginBean) o;
        String code = loginBean.getCode();
        if(code.equals("500")){
            Toast.makeText(this,"手机号或密码错误",Toast.LENGTH_SHORT).show();
        }else{
            Log.e("onSuccessonSuccess","onSuccessonSuccess聂雁宾"+loginBean.getUser().getUserPhone());
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
        }

    }

    @Override
    public void onError(Object o) {

    }
}
