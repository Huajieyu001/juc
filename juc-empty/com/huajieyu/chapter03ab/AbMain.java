package com.huajieyu.ab;

public class AbMain {

    public static void main(String[] args) {
        AbExe exe = new AbExe();
        new Thread(() -> {
            for (int i = 0; i < 100; i++){
                System.out.println(exe.getNum());
                exe.add();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++){
                System.out.println(exe.getNum());
                exe.sub();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "BB").start();
    }
}
