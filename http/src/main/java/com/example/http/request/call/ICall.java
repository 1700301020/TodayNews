package com.example.http.request.call;

import com.example.http.request.IRequest;
import com.example.http.response.IResponse;

public interface ICall {
    IResponse executed();

    IRequest getRequest();
}
