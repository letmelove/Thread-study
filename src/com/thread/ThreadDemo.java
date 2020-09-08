package com.thread;

//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
//线程开启不一定立即执行，由cpu调度执行
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("执行run：" + i);
        }
    }

    //main线程，主线程
    public static void main(String[] args) {

        ThreadDemo threadDemo = new ThreadDemo();

        //调用start()开启线程
        threadDemo.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("执行main方法：" + i);
        }
    }
}
