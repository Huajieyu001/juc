package com.huajieyu.lock;

public class LockSales {

    public static void main(String[] args) {
        LockTicket ticket = new LockTicket();

        for(int i = 0; i < 3; i++){
            new Thread(() -> {

                for(int j = 0;j < 40; j++){
                    ticket.sale();
                }
            }, "Thr" + i).start();
        }

    }
}
