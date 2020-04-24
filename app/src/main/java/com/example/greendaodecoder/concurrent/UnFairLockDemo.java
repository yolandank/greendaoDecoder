package com.example.greendaodecoder.concurrent;

import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnFairLockDemo {
    private static volatile UnFairLockDemo instance;
    private static final String TAG = "UnFairLockDemo";

    private UnFairLockDemo() {

    }

    public static UnFairLockDemo getInstance() {
        if (instance == null) {
            synchronized (UnFairLockDemo.class) {
                if (instance == null) {
                    instance = new UnFairLockDemo();
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

    public void alternateTask() {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 65; i < 91; i++) {
                        Log.d(TAG, "----------thread1------- " + (char) i);
                        condition2.signal();
                        condition1.await();
                    }
                    condition2.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 26; i++) {
                        Log.d(TAG, "----------thread2------- " + i);
                        condition1.signal();
                        condition2.await();
                    }
                    condition1.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
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
            Log.d(TAG, Thread.currentThread().getId() + " 线程 START  " + tag);
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
                Log.d(TAG, Thread.currentThread().getId() + " 线程 获得： Lock  ---》" + tag + "  Index:" + indext);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

}
