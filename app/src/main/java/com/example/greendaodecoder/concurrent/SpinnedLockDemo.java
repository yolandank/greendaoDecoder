package com.example.greendaodecoder.concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class SpinnedLockDemo {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();

    public void lock() {
        Thread current = Thread.currentThread();
        // 利用CAS
        while (!cas.compareAndSet(null, current)) {
            // DO nothing
        }
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
