package com.example.todaynews.splash;

import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpController;

public interface ISplashActivityContract {

    interface IView extends IMvpView {

        void setTvText(String s);
    }

    interface IPresenter extends ILifeCircle {

        void initTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvText(String s) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
