package com.example.mvp.mvp.presenter;

import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpController;

import java.lang.ref.WeakReference;

//抽象中介者 获取和保存V层的引用
public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {

    private WeakReference weakReference;

    public LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView){
        super();
        attachView(iMvpView);
        MvpController mvpController = iMvpView.getMvpController();
        mvpController.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        //弱引用
        if (weakReference == null){
            weakReference = new WeakReference(iMvpView);
        }else {
            T view = (T) weakReference.get();
            if (view != iMvpView){
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        //清除弱引用
        weakReference = null;
    }

    //获取对应view的方法
    public T getView(){
        T view = weakReference != null ? (T) weakReference.get() : null;
        if (view == null) {
            return getEmptyView();
        }
        return view;
    }

    //给子类去处理View为空的情况
    protected abstract T getEmptyView();
}
