package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dell.quarter.R;

/**
 * 引导页
 */
public class AuideActivity extends BaseActivity {

    private TextView tv;
    private int i=3;
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if(i==0){
            Intent intent=new Intent(AuideActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        tv.setText(i+"秒后");
        i--;

        handler.sendEmptyMessageDelayed(900,1000);
    }
};




    @Override
    int setViewId() {
        return R.layout.activity_auide;
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        tv = findViewById(R.id.tv);
        tv.setText("4秒后");
    }
//逻辑操作
    @Override
    void initLogic() {
        handler.sendEmptyMessageDelayed(900,1000);
    }
}
