package com.thread;

/**
 * 守护线程
 */
public class ThreadDaemon {


    public static void main(String[] args) {
        ATest a =new ATest();
        BTest b=new BTest();

        Thread thread=new Thread(a);
        thread.setDaemon(true); //默认是false表示是用户线程，正常的线程都是用户线程
        thread.start();

        new Thread(b).start();
    }

}

class ATest implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("守护线程");
        }
    }
}

class BTest implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("用户线程");
        }
        System.out.println("========用户线程执行完毕=========");

    }
}
