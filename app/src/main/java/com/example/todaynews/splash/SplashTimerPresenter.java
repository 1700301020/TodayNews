package com.example.todaynews.splash;

import com.example.mvp.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.IView iMvpView) {
        super(iMvpView);
    }


    public void initTimer() {
        timer = new CustomCountDownTimer(3, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvText(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvText("跳过");
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }

    //防止空指针异常
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }
}
