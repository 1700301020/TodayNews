package com.example.http;

import com.example.http.request.IRequest;
import com.example.http.result.IResult;

import java.util.Map;

public class LfHttpServer {
    public <T> IResult<T> executed(IRequest request, Map<String,Object> params){
        return HttpHelper.executed(request, params);
    }
}
