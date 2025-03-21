package com.huajieyu.chapter04threads;

public class ThreadsComBySyn {

    public static void main(String[] args) {
        AdvanceShare2 share = new AdvanceShare2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                share.increment();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                share.decrement();
            }
        }, "BBB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                share.increment();
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++){
                share.decrement();
            }
        }, "DDD").start();
    }
}

class AdvanceShare2{
    private int number = 0;

    public synchronized void increment() {
        while(number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        number ++;
        System.out.println(Thread.currentThread().getName() + "执行了increment，number = " + number);
        this.notifyAll();
    }

    public synchronized void decrement(){
        while(number != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        number --;
        System.out.println(Thread.currentThread().getName() + "执行了decrement，number = " + number);
        this.notifyAll();
    }
}
