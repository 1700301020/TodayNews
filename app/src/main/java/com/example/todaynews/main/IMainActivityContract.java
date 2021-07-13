package com.example.todaynews.main;

import androidx.fragment.app.Fragment;

import com.example.mvp.mvp.ILifeCircle;
import com.example.mvp.mvp.IMvpView;
import com.example.mvp.mvp.MvpController;


public interface IMainActivityContract {

    interface IView extends IMvpView {
        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCircle {
        void initHomeFragment();

        int getCurrentCheckedId();

        void changeFragment(int i);

        int getCurrentFragmentIndex();

        int getTopPosition();

        int getBottomPosition();
    }

    IView emptyView = new IView() {
        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
