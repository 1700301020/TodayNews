package com.example.todaynews.main.shanghai.dto;

import java.util.ArrayList;

public class ShangHaiBeanDataManager {

    //封装纵向数据
    private static ArrayList<ShangHaiBean> getVerticalData(int length){
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ShangHaiBean bean = new ShangHaiBean();
            bean.setShowImg(false);
            bean.setDec("我想去上海");
            data.add(bean);
        }
        return data;
    }

    //封装横向数据
    private static ArrayList<ShangHaiBean> getHorizontalData(int length){
        ArrayList<ShangHaiBean> data = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ShangHaiBean bean = new ShangHaiBean();
            bean.setShowImg(true);
            bean.setDec("我爱上海");
            data.add(bean);
        }
        return data;
    }

    //向外提供数据
    public static ArrayList<ShangHaiBean> getData(){
        ArrayList<ShangHaiBean> result = new ArrayList<>();
        //设置纵向数据
        result.addAll(getVerticalData(10));
        //设置横向数据
        ShangHaiBean beanFirst = new ShangHaiBean();
        beanFirst.setData(getHorizontalData(15));
        beanFirst.setItemType(ShangHaiBean.IShanghaiItemType.HORIZONTAL);
        result.add(beanFirst);
        //设置纵向数据
        result.addAll(getVerticalData(10));
        //设置横向数据
        ShangHaiBean beanSecond = new ShangHaiBean();
        beanSecond.setData(getHorizontalData(15));
        beanSecond.setItemType(ShangHaiBean.IShanghaiItemType.HORIZONTAL);
        result.add(beanSecond);
        return result;
    }
}
