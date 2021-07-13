package com.example.todaynews.main.shanghai.protocol;

import androidx.fragment.app.Fragment;

import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpController;


public interface IShanghaiDetailContract {

    interface IView extends IMvpView {
    }

    interface IPresenter extends ILifeCircle {
        void getNetData();
    }

    IView emptyView = new IView() {
        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
