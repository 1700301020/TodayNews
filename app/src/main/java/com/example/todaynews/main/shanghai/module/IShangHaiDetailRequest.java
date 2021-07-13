package com.example.todaynews.main.shanghai.module;

import com.example.http.annotation.RequestMethod;
import com.example.http.request.IRequest;
import com.example.todaynews.base.JuHeRequest;
import com.example.todaynews.main.shanghai.dto.ShangHaiDetailBean;

public interface IShangHaiDetailRequest {
    IRequest jokeRequest = JuHeRequest.sendHttp("/joke/content/list.php", RequestMethod.GET, ShangHaiDetailBean.class);
}
