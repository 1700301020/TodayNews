package com.example.todaynews.main.shanghai.module;

import com.example.http.LfHttpServer;
import com.example.http.result.IResult;

import java.util.HashMap;
import java.util.Map;

public class ShangHaiDetailHttpTask<T> extends LfHttpServer {

    //负责封装参数
    public IResult<T> getJokeList(String sort, String page, String pagesize){
        Map<String,Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("page", page);
        params.put("pagesize", pagesize);
        params.put("time", System.currentTimeMillis() / 1000 + "");
        params.put("key", "e1ffc011820d4c36cef7271f7e89b735");
        return super.executed(IShangHaiDetailRequest.jokeRequest,params);
    }

}
