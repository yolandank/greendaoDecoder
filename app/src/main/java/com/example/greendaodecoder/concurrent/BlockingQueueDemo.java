package com.example.greendaodecoder.concurrent;

import android.util.Log;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueDemo {

    private static volatile BlockingQueueDemo instance;

    private BlockingQueueDemo() {

    }

    public static BlockingQueueDemo getInstance() {
        if (instance == null) {
            synchronized (BlockingQueueDemo.class) {
                if (instance == null) {
                    instance = new BlockingQueueDemo();
                }
            }
        }
        return instance;
    }

    private static final String TAG = "BlockingQueueDemo";

    public void run() {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        //入列
        queue.offer("1");
        queue.offer("5");
        queue.offer("3");
        queue.offer("2");
        queue.offer("4");

        //出列
        while (!queue.isEmpty()) {
            Log.d(TAG, "run: " + queue.poll());
        }
    }
}
