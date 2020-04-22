package com.example.greendaodecoder.concurrent;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    private static final String TAG = "FutureTaskDemo";
    private static volatile FutureTaskDemo instance;

    private FutureTaskDemo() {

    }

    public static FutureTaskDemo getInstance() {
        if (instance == null) {
            synchronized (FutureTaskDemo.class) {
                if (instance == null) {
                    instance = new FutureTaskDemo();
                }
            }
        }
        return instance;
    }

    public void run() {
        //第一种方式
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Log.d(TAG, "call: 子线程在进行计算");
                Thread.sleep(3000);
                int sum = 0;
                for (int i = 0; i < 100; i++)
                    sum += i;
                return sum;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        executor.submit(futureTask);
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
//        Task task = new Task();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        Thread thread = new Thread(futureTask);
//        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        Log.d(TAG, "run: 主线程在执行任务");

        try {
            if (futureTask.get() != null) {
                Log.d(TAG, "task运行结果" + futureTask.get());
            } else {
                Log.d(TAG, "future.get()未获取到结果");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "run: 所有任务执行完毕");
    }
}