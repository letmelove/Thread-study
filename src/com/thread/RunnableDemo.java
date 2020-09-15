package com.thread;

/**
 * 创建线程方式二：实现Runnable接口，重写run方法，执行线程需要丢入Runnable接口实现类，调用start方法
 */
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("执行run：" + i);
        }
    }

    //main线程，主线程
    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();
        //创建线程对象，通过线程对象来开启线程
        new Thread(runnableDemo).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("执行main方法：" + i);
        }
    }
}
