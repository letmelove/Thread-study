package com.syn;

/**
 * 不安全的买票
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket bt=new BuyTicket();

        new Thread(bt,"小明").start();
        new Thread(bt,"小红").start();
        new Thread(bt,"小里").start();
    }
}

class BuyTicket implements Runnable{
    private int ticketNum=10;
    private boolean flag=true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized:默认锁的是this 这个例子锁的对象就是BuyTicket
    private synchronized void buy() throws InterruptedException {
        if (ticketNum<=0){
            flag=false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"拿到了第:"+ticketNum--+"张票");
    }
}