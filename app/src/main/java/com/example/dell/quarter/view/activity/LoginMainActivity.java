package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.quarter.R;

public class LoginMainActivity extends BaseActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginMainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    int setViewId() {
        return R.layout.activity_login_main;
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        tv = findViewById(R.id.logintv);
    }
}
