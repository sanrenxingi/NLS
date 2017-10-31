package com.example.dell.quarter.view.activity;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.RegisterBean;
import com.example.dell.quarter.modle.utils.ClassPathResource;
import com.example.dell.quarter.presenter.RegisterPresenter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

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
    int setViewId() {
        Fresco.initialize(this);//初始化在加载布局的上面
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
        SimpleDraweeView simpleDraweeView= this.findViewById(R.id.sdv);
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setAutoPlayAnimations(true)
                //设置uri,加载本地的gif资源
                .setUri(Uri.parse("res://"+getPackageName()+"/"+R.raw.nyba))
                .build();
        //设置Controller
        simpleDraweeView.setController(draweeController);


    }
//逻辑操作
    @Override
    void initLogic() {
        //注册的点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //逻辑判断方法
                phone = etzh.getText().toString();
                mima = etmm.getText().toString();
                boolean mobileNO = ClassPathResource.isMobileNO(phone);
                if(mobileNO==true){
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
                            registerPresenter.attachView(RegisterActivity.this);
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this,"手机号不为11位，请重新输入",Toast.LENGTH_SHORT).show();
                            etzh.setText("");
                            etmm.setText("");
                        }

                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"手机号是黑户",Toast.LENGTH_SHORT).show();
                }



            }
        });
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registerPresenter.dettachView();
    }
}
