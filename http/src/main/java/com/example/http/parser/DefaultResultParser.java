package com.example.http.parser;

import android.util.Log;

import com.example.http.request.IRequest;
import com.example.http.response.IResponse;
import com.example.http.result.IResult;
import com.example.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class DefaultResultParser implements IParser{

    private static DefaultResultParser mInstance;
    private final Gson gson;

    public DefaultResultParser() {
        gson = new Gson();
    }

    public static IParser getInstance() {
        if (mInstance == null){
            mInstance = new DefaultResultParser();
        }
        return mInstance;
    }

    @Override
    public IResult parserResponse(IRequest request, IResponse response) {
        Type type = request.getType();
        String bodyString = response.getBodyString();
        Object object = gson.fromJson(bodyString, type);
        return Result.success(object);
    }
}
