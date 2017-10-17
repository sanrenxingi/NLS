package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dell.quarter.R;

public class LoginActivity extends BaseActivity {

    private TextView zhuce;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册跳转
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        //登录跳转
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
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

    }
     //找ID
    @Override
    void initView() {
        zhuce = findViewById(R.id.zhuce);
        btnlogin = findViewById(R.id.loginbtn);
    }
}
