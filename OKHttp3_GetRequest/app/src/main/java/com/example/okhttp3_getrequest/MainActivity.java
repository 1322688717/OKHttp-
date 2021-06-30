package com.example.okhttp3_getrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.okhttp3_getrequest.until.OkHttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.okhttp3_getrequest.until.Confit.intent;
import static com.example.okhttp3_getrequest.until.Confit.url_login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        post();
    }

    private void post() {
        OkHttp okHttp = new OkHttp();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("","");
        okHttp.postrequest(url_login, builder, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","网络求请失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","网络请求成功:"+response.body().string());
            }
        });
    }

    private void init() {
        OkHttp okHttp = new OkHttp();
        okHttp.getrequest(intent, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG","网络求请失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e("TAG","网络请求成功:"+response.body().string());
            }
        });
    }
}