package com.thread;

/**
 * 停止线程
 * 建议线程正常停止--->利用次数，不建议死循环
 * 建议使用标识---->设置一个标识
 * 不要使用stop或者destroy等过时或者jdk不建议使用的方法
 */
public class ThreadStop implements Runnable {

    //设置标识
    private boolean flag=true;

    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("run thread:"+i++);
        }
    }

    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        ThreadStop ts=new ThreadStop();
        new Thread(ts).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main:"+i);
            if(i==900){
                ts.stop();
            }
        }
    }
}
