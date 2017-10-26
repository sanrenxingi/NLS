package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.dell.quarter.R;

/**
 * 创作页面
 * 聂雁宾
 */
public class CreateActivity extends BaseActivity {

    private ImageView imgvideo;
    private ImageView imgduanzi;

    @Override
    int setViewId() {
        return R.layout.activity_create;
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        imgvideo = findViewById(R.id.imgvideo);
        imgduanzi = findViewById(R.id.imgduanzi);
    }
//逻辑操作
    @Override
    void initLogic() {
        //视频的点击事件
        imgvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CreateActivity.this,VideoCreateActivity.class);
                startActivity(intent);
            }
        });
        //段子的点击事件
        imgduanzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CreateActivity.this,Write_Cross_talkActivity.class);
                startActivity(intent);
            }
        });
    }
}
