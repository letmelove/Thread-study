package com.senior;

/**
 *生产者消费者模型--->信号灯法。使用标志位解决
 */
public class PCDemo2 {
    public static void main(String[] args) {
        Tv tv=new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }

}
//生产者--->演员
class Player extends Thread{
    Tv tv;
    public Player(Tv tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i%2==0){
                this.tv.play("喜剧");
            }else{
                this.tv.play("广告");
            }
        }
    }
}
//消费者--->观众
class Watcher extends Thread{
    Tv tv;
    public Watcher(Tv tv){
        this.tv=tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}
//产品--->节目
class Tv{
    //演员拍摄，观众等待   T
    //观众观看，演员等待   F
    String voice;//表演的节目
    boolean flag=true;
    //表演
    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("演员拍摄了:"+voice);
        //通知观众观看
        this.notifyAll();//唤醒等待的线程

        this.voice=voice;
        this.flag=!this.flag;
    }
    //观看
    public synchronized void watch(){
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观众观看:"+voice);

        this.notifyAll();
        this.flag=!this.flag;

    }
}
