package com.example.dell.quarter.modle.http;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.dell.quarter.modle.bean.RegisterBean;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_M;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by dell on 2017/10/17.
 */

public class RegisterHttp<T> {
    private RegisterInterfaceP_M P_M;
    private OkHttpClient client;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            T t = (T) msg.obj;
           P_M.onSuccess(t);

        }
    };
    //get网络请求
    public <T> void doGet(String url, Map<String, String> params, final Class<T> clazz) {
        client = new OkHttpClient.Builder()
                .build();
        Request.Builder builder = new Request.Builder();
//        headers.putAll(params);
        //第一种遍历map集合的方式
        StringBuffer buffer = new StringBuffer();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            buffer.append(entry.getKey() + "=" + entry.getValue() + "&");
        }

        builder.url(url+"?" + buffer);
        //第二种遍历方式
//       for (String key:headers.keySet()){
//           String value = headers.get(key);
//           builder.addHeader(key,value);
//       }
        //第三种遍历方式
//        Iterator<Map.Entry<String, String>> it = headers.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry<String , String> entry=it.next();
//            builder.addHeader(entry.getKey(),entry.getValue());
//        }
        Request request = builder.build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("aaa", response.toString());
                if (response.isSuccessful()) {
                    String value = response.body().string();
                    T t = new Gson().fromJson(value, clazz);
                    Message msg = handler.obtainMessage();
                    msg.obj = t;
                    handler.sendMessage(msg);
                }
            }
        });
    }
    //post网络请求
    public void doPost(String url, Map<String, String> parmas, final Class<T> clazz) {
        client = new OkHttpClient.Builder()
                .build();
        FormBody.Builder builder = new FormBody.Builder();
//        headers.putAll(parmas);
        for (Map.Entry<String, String> entry : parmas.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody formbody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(formbody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String result = response.body().string();
                    T t = new Gson().fromJson(result, clazz);
                    Message msg = handler.obtainMessage();
                    msg.obj = t;
                    handler.sendMessage(msg);
                }
            }
        });

    }
    public void onCallBack(RegisterInterfaceP_M call) {
        this.P_M = call;
    }

}
