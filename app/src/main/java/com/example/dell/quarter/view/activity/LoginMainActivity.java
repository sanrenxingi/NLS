package com.example.dell.quarter.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.utils.App;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginMainActivity extends BaseActivity {
    private UMShareAPI umShareAPI;
    private TextView tv;
    private ImageView qqimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App app= (App) getApplication();
        umShareAPI = app.getUmShareAPI();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginMainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        qqimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取信息
                umShareAPI.getPlatformInfo(LoginMainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        if (share_media == SHARE_MEDIA.QQ) {

                            String name = map.get("name");
                            String img = map.get("iconurl");
                          Intent intent=new Intent(LoginMainActivity.this,MainActivity.class);
                            intent.putExtra("name",name);
                            intent.putExtra("img",img);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });

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
        qqimg = findViewById(R.id.qqimg);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
