package com.example.http.result;

//所有IResponse 解析后的结果
public interface IResult<T> {
    boolean isSuccess();

    int getCode();

    T getData();
}
