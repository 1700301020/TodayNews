package com.example.http;

import android.util.Log;

import com.example.http.parser.IParser;
import com.example.http.request.IRequest;
import com.example.http.request.call.ICall;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;

public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public IResult executed(ICall call) {
        //IResponse 和IResult 进行一个转换
        IResponse response = call.executed();
        IRequest request = call.getRequest();
        IParser parser = request.getParser();
        return parser.parserResponse(request,response);
    }
}
