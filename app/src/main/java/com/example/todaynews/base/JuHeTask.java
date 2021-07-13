package com.example.todaynews.base;

import android.util.Log;

import com.example.http.result.IResult;
import com.example.http.result.IResultCallBack;
import com.example.http.result.Result;
import com.example.task.LfTask;

public abstract class JuHeTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {

    @Override
    public void onComplete(IResult<T> result) {
        if (result != null) {
            if (result.isSuccess()) {
                Log.d("onComplete","isSuccess --> " + result.isSuccess());
                onSuccess(result);
            } else {
                onFailed(Result.failed(Result.CODE_504));
            }
        } else {
            onFailed(Result.failed(Result.CODE_404));
        }
    }

    @Override
    public void onFailed(IResult t) {
        //统一错误码处理
        switch (t.getCode()) {
            case Result.CODE_404:
            case Result.CODE_504:
                break;
        }
    }

    @Override
    public void onException(Throwable throwable) {
        onFailed(Result.failed(Result.CODE_505));
    }
}
