package com.example.dell.quarter.modle.http;

import android.os.Handler;
import android.os.Message;

import com.example.dell.quarter.view.interfaces.RecommendHot_m;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类描述：推荐下的热门界面的m层
 * 姓名 ：刘希鑫
 */

public class RecommendHotModle {
    private RecommendHot_m re;
    private Gson gson;

    public void getrecomm(RecommendHot_m recommendHotM){
        this.re=recommendHotM;
        gson = new Gson();
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
          Object object=  msg.obj;
            re.onSuccess(object);
        }
    };

    public void getHttp(String url, final Class clazz){
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(new HttpInterceptor()).build();
        Request request=new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Object o=gson.fromJson(string,clazz);
                Message msg=handler.obtainMessage();
                msg.obj=o;
                handler.sendMessage(msg);

            }
        });

    }

}
