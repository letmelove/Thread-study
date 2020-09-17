package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 模拟倒计时
 * 实时获取系统当前时间
 */
public class ThreadSleep2 {

    public static void main(String[] args) throws InterruptedException {
        //countDown();
        newTime();
    }

    public static void newTime() throws InterruptedException {

        while(true){
            Thread.sleep(1000);
            Date time=new Date(System.currentTimeMillis());//获取系统当前时间
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(time));
        }
    }

    //倒计时方法
    public static void countDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }
}
