package com.huajieyu.pak.p30.p32;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockWrite2Read {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

        // 写锁降级读锁
        writeLock.lock();
        System.out.println("AAAAA");
        readLock.lock();
        System.out.println("BBBBB");
        writeLock.unlock();
        System.out.println("CCCCC");
        readLock.unlock();
    }
}
