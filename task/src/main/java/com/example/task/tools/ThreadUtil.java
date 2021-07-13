package com.example.task.tools;

import android.os.Handler;
import android.os.Looper;

//工具类
public class ThreadUtil {

    //主线程的Handler
    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    //获取CPU核心
    public static int CORE_NUM = Runtime.getRuntime().availableProcessors();

    public static void postMainThread(Runnable runnable) {
        MAIN.post(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
