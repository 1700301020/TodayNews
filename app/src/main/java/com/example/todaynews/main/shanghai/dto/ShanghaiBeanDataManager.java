package com.example.todaynews.main.shanghai.dto;

import java.util.ArrayList;

public class ShanghaiBeanDataManager {

    //封装纵向数据
    private static ArrayList<ShanghaiBean> getVerticalData(int length){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(false);
            bean.setDec("我想去上海");
            data.add(bean);
        }
        return data;
    }

    //封装横向数据
    private static ArrayList<ShanghaiBean> getHorizontalData(int length){
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(true);
            bean.setDec("我爱上海");
            data.add(bean);
        }
        return data;
    }

    //向外提供数据
    public static ArrayList<ShanghaiBean> getData(){
        ArrayList<ShanghaiBean> result = new ArrayList<>();
        //设置纵向数据
        result.addAll(getVerticalData(10));
        //设置横向数据
        ShanghaiBean beanFirst = new ShanghaiBean();
        beanFirst.setData(getHorizontalData(15));
        beanFirst.setItemType(ShanghaiBean.IShanghaiItemType.HORIZONTAL);
        result.add(beanFirst);
        //设置纵向数据
        result.addAll(getVerticalData(10));
        //设置横向数据
        ShanghaiBean beanSecond = new ShanghaiBean();
        beanSecond.setData(getHorizontalData(15));
        beanSecond.setItemType(ShanghaiBean.IShanghaiItemType.HORIZONTAL);
        result.add(beanSecond);
        return result;
    }
}
