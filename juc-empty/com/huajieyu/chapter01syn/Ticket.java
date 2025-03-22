package com.huajieyu.syn;

public class Ticket {

    private static int count = 30;

    public synchronized void sale(){
        if(count > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了编号为" + getCount() + "的票！");
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
