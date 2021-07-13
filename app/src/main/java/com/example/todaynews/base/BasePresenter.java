package com.example.todaynews.base;

import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.base.BaseMvpPresenter;
import com.example.task.LfTask;
import com.example.task.TaskHelper;

//集成MVP以及网络模块 的桥接类
public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T iMvpView) {
        super(iMvpView);
    }
    public void submitTask(LfTask task){
        TaskHelper.submitTask(task,task);
    }
}
