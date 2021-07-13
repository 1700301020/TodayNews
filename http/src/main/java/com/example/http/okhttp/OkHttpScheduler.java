package com.example.http.okhttp;

import android.util.Log;

import com.example.http.HttpScheduler;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.IRequest;
import com.example.http.request.call.ICall;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpScheduler extends HttpScheduler {

    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();

        switch (requestMethod) {
            case RequestMethod.GET:
                HttpGetMethod(request, params, requestBuilder);
                break;
            case RequestMethod.POST:
                HttpPostMethod(request, params, requestBuilder);
                break;
        }

        Call call = getClient().newCall(requestBuilder.build());
        OkHttpCall okHttpCall = new OkHttpCall(request, call);
        return okHttpCall;
    }

    //Post方法请求
    private void HttpPostMethod(IRequest request, Map<String, Object> params, Request.Builder requestBuilder) {
        //拼接Post请求的URL HOST+PATH
        StringBuilder urlPostBuilder = new StringBuilder(request.getHost().getHost());
        urlPostBuilder.append(request.getPath());
        //POST请求
        FormBody.Builder fromBodyBuilder = new FormBody.Builder();
        Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            //todo 这里涉及对象转成字符串的知识
            fromBodyBuilder.add(next.getKey(), String.valueOf(next.getValue()));
        }
        requestBuilder.post(fromBodyBuilder.build()).url(urlPostBuilder.toString());
    }

    //Get方法请求
    private void HttpGetMethod(IRequest request, Map<String, Object> params, Request.Builder requestBuilder) {
        Log.d("HttpGetMethod","我执行了");
        //拼接GET请求的URL HOST+PATH
        StringBuilder urlGetBuilder = new StringBuilder(request.getHost().getHost());
        urlGetBuilder.append(request.getPath());
        //GET请求
        HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(urlGetBuilder.toString()).newBuilder();
        if (params != null && params.size() > 0) {
            Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Object> next = iterator.next();
                //todo 这里涉及对象转成字符串的知识
                httpUrlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
            }
        }
        requestBuilder.get().url(httpUrlBuilder.build());
    }

    private OkHttpClient getClient() {
        if (this.client == null) {
            this.client = new OkHttpClient();
        }
        return client;
    }
}
