package com.huajieyu.ab;

import java.util.concurrent.locks.ReentrantLock;

public class AbExe {

    private final ReentrantLock lock = new ReentrantLock();

    private static int num = 0;

    public void add() {
        lock.lock();
        try {
            if (num == 0) {
                num++;
            }
        } finally {
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        try {
            if (num > 0) {
                num--;
            }
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        lock.lock();
        int temp = -1;
        try {
            temp = num;
        } finally {
            lock.unlock();
        }
        return temp;
    }
}
