package com.huajieyu.syn;

public class Sales {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        for(int i = 0; i < 3; i++){
            new Thread(() -> {

                for(int j = 0;j < 40; j++){
                    ticket.sale();
                }
            }, "Thr" + i).start();
        }

    }
}
