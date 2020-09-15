package com.thread;

/**
 * 模拟买票
 * 问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱
 */
public class TestThread implements Runnable {

    //飘数
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
        TestThread testThread = new TestThread();
        new Thread(testThread, "张三").start();
        new Thread(testThread, "李四").start();
        new Thread(testThread, "旺旺").start();
    }
}
