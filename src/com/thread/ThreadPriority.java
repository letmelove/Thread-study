package com.thread;

/**
 * 线程优先级 取值范围:1~10
 */
public class ThreadPriority {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority=new MyPriority();

        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);

        //setPriority():设置线程优先级
        t1.setPriority(5);
        t1.start();

        t2.setPriority(3);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(2);
        t4.start();

        t5.setPriority(7);
        t5.start();


        t6.setPriority(Thread.MAX_PRIORITY);
        t6.start();


    }
}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
