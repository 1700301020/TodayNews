package com.example.todaynews.base;

import com.example.http.request.host.IHost;

public interface IJuHeHostManager {
    IHost juheHost = new IHost() {

        @Override
        public String getHost() {
            return "http://v.juhe.cn";
        }

        @Override
        public String getDefaultPath() {
            return "/joke/content/list.php";
        }
    };
}
