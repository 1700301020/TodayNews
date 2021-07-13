package com.example.todaynews.main.shanghai.dto;

import java.util.List;

public class ShangHaiDetailBean {

    public Integer errorCode;
    public String reason;
    public ResultDTO result;

    public static class ResultDTO {
        public List<DataDTO> data;

        public static class DataDTO {
            public String content;
            public String hashId;
            public Integer unixtime;
            public String updatetime;

            @Override
            public String toString() {
                return "DataDTO{" +
                        "content='" + content + '\'' +
                        ", hashId='" + hashId + '\'' +
                        ", unixtime=" + unixtime +
                        ", updatetime='" + updatetime + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "ResultDTO{" +
                    "data=" + data +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ShangHaiDetailBean{" +
                "errorCode=" + errorCode +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
