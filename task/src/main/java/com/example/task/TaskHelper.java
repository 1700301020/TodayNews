package com.example.task;

public class TaskHelper {

    public static void submitTask(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        AsyncTaskInstance asyncTaskInstance = AsyncTaskInstance.getInstance(iTaskBackground,iTaskCallback);
        //构建线程池管理器
        TaskScheduler.getInstance().submit(asyncTaskInstance);
    }
}
