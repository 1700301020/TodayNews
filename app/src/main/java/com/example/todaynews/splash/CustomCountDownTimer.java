package com.example.todaynews.splash;

import android.os.Handler;

/**
 * 计时器类
 * 需求
 * 1、实时去回调，知道现在是什么时间 --> 观察者设计模式
 * 2、支持动态传入总时间 --> 构造函数
 * 3、每过一秒，时间减一 --> Handler
 * 4、倒计时为0，要回调完成状态
 */
public class CustomCountDownTimer implements Runnable {

    private int time;//总时间
    private ICountDownHandler countDownHandler;
    private boolean isRun;//线程运行的标志位
    private int countDownTime;//倒计时时间
    Handler handler = new Handler();


    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler) {
        this.time = time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }

    //倒计时
    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                //执行倒计时
                countDownHandler.onTicker(countDownTime);
            }
            //倒计时为0
            if (countDownTime == 0) {
                cancel();
                if (countDownHandler != null) {
                    //倒计时结束
                    countDownHandler.onFinish();
                }
            } else {
                //时间减一
                countDownTime = time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    //开启倒计时
    public void start(){
        isRun = true;
        handler.post(this);
    }

    //结束倒计时
    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }
    /*
    观察者设计模式
    1、定义一个接口
     */
    public interface ICountDownHandler {
        //倒计时
        void onTicker(int time);

        //结束
        void onFinish();
    }
}
