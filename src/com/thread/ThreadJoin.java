package com.thread;

/**
 * join()方法：让线程强制执行，其它线程阻塞
 */
public class ThreadJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("线程 run"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin tj=new ThreadJoin();
        Thread thread =new Thread(tj);
        thread.start();

        for (int i = 0; i < 200; i++) {
            if(i==100){
                thread.join();
            }
            System.out.println("main run"+i);
        }
    }
}
