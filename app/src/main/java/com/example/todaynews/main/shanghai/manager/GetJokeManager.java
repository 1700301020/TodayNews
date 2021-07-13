package com.example.todaynews.main.shanghai.manager;

import android.os.AsyncTask;
import android.util.Log;

import com.example.todaynews.main.shanghai.module.ShangHaiDetailHttpTask;

import java.io.IOException;

import okhttp3.Response;

public class GetJokeManager extends AsyncTask<Object, Object, Object> {

    //运行在子线程中
    @Override
    protected Object doInBackground(Object... objects) {
        Object desc = new ShangHaiDetailHttpTask().getJokeList((String) objects[0], (String) objects[1], (String) objects[2]);
        return desc;
    }

    //运行在主线程中 用于更新数据
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response response = (Response) o;
        Log.d("onPostExecute", response.body().toString());
    }
}
