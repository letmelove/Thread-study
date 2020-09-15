package com.thread;

public class Race implements Runnable {

    private String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(Thread.currentThread().getName().equals("兔子")){
                try {
                    //使线程进入睡眠状态
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(gemaOver(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"米");
        }
    }

    public boolean gemaOver(int m){
        //如果已经存在胜利者
        if(winner!=null){
            return true;
        }{
           if(m==100){
               winner=Thread.currentThread().getName();
               System.out.println("winner is"+winner);
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race=new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
