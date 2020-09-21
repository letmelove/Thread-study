package com.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * list线程不安全是因为：当有多个线程在操作同一个位置，就会把数据覆盖，所以说线程不安全
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }

            }).start();
        }

        Thread.sleep(3000);
        System.out.println(list.size());
    }
}
