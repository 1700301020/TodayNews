package com.example.http.result;

public interface IResultCallBack<T> {

    void onSuccess(IResult<T> t);

    void onFailed(IResult t);
}
