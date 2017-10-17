package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dell.quarter.R;

public class MainActivity extends BaseActivity {

    private TextView zhuce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
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
    }
}
