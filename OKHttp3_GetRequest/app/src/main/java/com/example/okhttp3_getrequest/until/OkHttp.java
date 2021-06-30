package com.example.okhttp3_getrequest.until;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 封装okhttp请求
 */
public class OkHttp {
    //get请求
    public static void getrequest(String url , Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //post请求
    public static void postrequest(String url, FormBody.Builder builder,Callback callback){
        OkHttpClient client = new OkHttpClient();
        FormBody build = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(build)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
