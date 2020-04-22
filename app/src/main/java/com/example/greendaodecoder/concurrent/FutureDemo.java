package com.example.greendaodecoder.concurrent;

import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    private static volatile FutureDemo instance;
    private static final String TAG = "FutureDemo";

    private FutureDemo() {

    }

    public static FutureDemo getInstance() {
        if (instance == null) {
            synchronized (FutureDemo.class) {
                if (instance == null) {
                    instance = new FutureDemo();
                }
            }
        }
        return instance;
    }

    public void run() {
        // 创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 创建Callable对象任务
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
        // 提交任务并获取执行结果
        Future<Integer> result = executor.submit(task);
        // 关闭线程池
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            if (result.get() != null) {
                Log.d(TAG, "task运行结果" + result.get());
            } else {
                Log.d(TAG, "run: 未获取到结果");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "run: 所有任务执行完毕");
    }
}
