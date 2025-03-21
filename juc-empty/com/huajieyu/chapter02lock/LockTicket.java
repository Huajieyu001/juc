package com.huajieyu.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTicket {

    private static int count = 30;
    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (count > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了编号为" + getCount() + "的票！");
                count--;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}
