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

public class RegisterActivity extends BaseActivity implements RegisterInterfaceP_V<RegisterBean> {

    private RegisterPresenter registerPresenter;
    private EditText etzh;
    private EditText etmm;
    private Button btn;
    private String phone;
    private String mima;
//    private int i=2;
//    private Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if(i==0){
//                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//            i--;
//            handler.sendEmptyMessageDelayed(900,1000);
//        }
//    };
    private HashMap<String, String> map;
    private Object code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //逻辑判断方法
                phone = etzh.getText().toString();
                mima = etmm.getText().toString();
                        map = new HashMap<>();
                map.put("userPhone",phone);
                map.put("userPassword",mima);
                registerPresenter.loadDataFromServer(map);
                registerPresenter.setview(RegisterActivity.this);
      finish();
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
       /* Log.e("dasdadad","dasdadadada"+code);
       String c1= (String) code;*/
//        String c= (String) code;

        if(code.equals("200")){
            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();


        } else{
            Toast.makeText(RegisterActivity.this,"手机号已被注册",Toast.LENGTH_SHORT).show();
        }




//        handler.sendEmptyMessageDelayed(900,1000);
        Log.e("onSuccessonSuccess","onSuccessonSuccess"+ registerBean.getCode());
    }

    @Override
    public void onError(RegisterBean o) {

    }
}
