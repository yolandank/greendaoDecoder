package com.example.greendaodecoder.concurrent;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static volatile ReentrantLockDemo instance;
    private static final String TAG = "ReentrantLockDemo";

    private ReentrantLockDemo() {

    }

    public static ReentrantLockDemo getInstance() {
        if (instance == null) {
            synchronized (ReentrantLockDemo.class) {
                if (instance == null) {
                    instance = new ReentrantLockDemo();
                }
            }
        }
        return instance;
    }

    public void run() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock unFairLock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            threadPool.submit(new TestThread(fairLock, i, " fairLock"));
            threadPool.submit(new TestThread(unFairLock, i, "unFairLock"));
        }
    }

    static class TestThread implements Runnable {
        Lock lock;
        int indext;
        String tag;

        public TestThread(Lock lock, int index, String tag) {
            this.lock = lock;
            this.indext = index;
            this.tag = tag;
        }

        @Override
        public void run() {
            Log.d(TAG, "run: " + Thread.currentThread().getId() + " 线程 START  " + tag);
            meath();
        }

        private void meath() {
            lock.lock();
            try {
                if ((indext & 0x1) == 1) {
                    Thread.sleep(200);
                } else {
                    Thread.sleep(500);
                }
                Log.d(TAG, "meath: " + Thread.currentThread().getId() + " 线程 获得： Lock  ---》" + tag + "  Index:" + indext);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}
