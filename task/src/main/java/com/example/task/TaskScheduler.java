package com.example.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.example.task.tools.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {

    private static final long KEEPALIVETIME = 1;
    private final int COREPOOLSIZE = ThreadUtil.CORE_NUM +1;
    private final int MAXIMUMPOOLSIZE = COREPOOLSIZE * 2;
    private final PriorityThreadPoolExecutor executor;
    private static TaskScheduler instance;
    private final Handler handler;
    interface ITaskSchedulerType {
        int SUBMIT_TASK = 0;
    }

    private TaskScheduler() {
        //用于消息调度的线程
        HandlerThread handlerThread = new HandlerThread("task-thread");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            //handlerThread handleMessage 运行在子线程
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what){
                    case ITaskSchedulerType.SUBMIT_TASK:
                        doSubmitTask((AsyncTaskInstance) msg.obj);
                        break;
                }
                return false;
            }
        });
        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();//无大小限制的队列
        //创建一个线程池
        this.executor = new PriorityThreadPoolExecutor(
                COREPOOLSIZE,
                MAXIMUMPOOLSIZE,
                KEEPALIVETIME,
                TimeUnit.MINUTES,
                workQueue,
                new TaskThreadFactory()
        );
    }

    private void doSubmitTask(AsyncTaskInstance taskInstance) {
        this.executor.submit(taskInstance);
    }

    public static TaskScheduler getInstance(){
        if (instance == null) {
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance asyncTaskInstance) {
        handler.sendMessage(handler.obtainMessage(ITaskSchedulerType.SUBMIT_TASK,asyncTaskInstance));
    }
}
