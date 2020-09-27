package com.thread;

/**
 * 线程礼让
 * 礼让不一定成功，还是看cpu来调度
 */
public class ThreadYield {

    public static void main(String[] args) {
        MyYield my=new MyYield();
        new Thread(my,"a").start();
        new Thread(my,"b").start();
    }

}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---->开始执行");
        //礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"---->线程结束");
    }
}