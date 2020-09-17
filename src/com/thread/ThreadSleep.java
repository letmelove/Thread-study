package com.thread;

/**
 * 买票案例
 * 模拟延时：放大问题的发生性
 */
public class ThreadSleep implements Runnable {

    //票数
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            if (ticket <=0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Thread.currentThread().getName():获取线程名
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        ThreadSleep testThread = new ThreadSleep();
        new Thread(testThread, "张三").start();
        new Thread(testThread, "李四").start();
        new Thread(testThread, "旺旺").start();
    }
}
