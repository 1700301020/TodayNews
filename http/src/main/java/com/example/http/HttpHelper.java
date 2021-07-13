package com.example.http;

import com.example.http.okhttp.OkHttpScheduler;
import com.example.http.request.IRequest;
import com.example.http.request.call.ICall;
import com.example.http.result.IResult;

import java.util.Map;

public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    //单例设计模式 双重校验
    public static HttpScheduler getHttpScheduler(){
        if (httpScheduler == null){
            synchronized (HttpHelper.class){
                if (httpScheduler == null) {
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }


    //todo 未完成
    public static <T> IResult<T> executed(IRequest request, Map<String, Object> params) {
        request.setParam(params);
        ICall call = getHttpScheduler().newCall(request);
        return getHttpScheduler().executed(call);
    }
}
