package com.cosage.zzh.wxmusic;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Zhengzhihui on 2018/5/29.
 */

public class Http {

    public static  void get(String key, final Callback callback) throws IOException {
        //String url = getUrl() + ":8080/do?key=" +key;
        String url = "http://www.baidu.com";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 callback.onResponse(call,response);
            }
        });

    }

    @NonNull
    private static String getUrl() {
        //return "http://39.104.179.52";
        return "http://127.0.0.1";
    }

    public static  String put(String key,String value) throws IOException {
        String url = getUrl()+":8080/put?key="+key+"&value="+value;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        okhttp3.Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            return "";
        }
    }
}
