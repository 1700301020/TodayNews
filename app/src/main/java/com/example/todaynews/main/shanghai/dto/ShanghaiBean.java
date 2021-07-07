package com.example.todaynews.main.shanghai.dto;

import java.util.ArrayList;

public class ShanghaiBean {

    private int mItemType = IShanghaiItemType.VERTICAL;//条目的类型
    private String mDec;//条目的内容、
    private boolean isShowImg;//是否展示图片
    private ArrayList<ShanghaiBean> data;//横向列表

    public int getItemType() {
        return mItemType;
    }

    public void setItemType(int mItemType) {
        this.mItemType = mItemType;
    }

    public String getDec() {
        return mDec;
    }

    public void setDec(String mDec) {
        this.mDec = mDec;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public void setShowImg(boolean showImg) {
        isShowImg = showImg;
    }

    public ArrayList<ShanghaiBean> getData() {
        return data;
    }

    public void setData(ArrayList<ShanghaiBean> data) {
        this.data = data;
    }

    public interface IShanghaiItemType{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }
}
