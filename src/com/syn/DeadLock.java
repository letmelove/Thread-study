package com.syn;

/**
 * 死锁：多个线程互相占用对方所需要的资源，形成的僵持
 * 产生死锁的四个必要条件：
 * 1.互斥条件：一个资源每次只能被一个进程使用
 * 2.请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放
 * 3.不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺
 * 4.循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系
 *
 * 只要破其中任意一个或多个条件，就可以避免死锁的发生
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0, "灰姑凉");
        Makeup m2 = new Makeup(1, "白雪公主");
        m1.start();
        m2.start();
    }
}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

class Makeup extends Thread {

    //用static来保证资源只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    //选择
    int choice;

    //使用化妆品的人
    String name;

    Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //化妆，互相持有对方的锁，就是需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            //获得口红的锁
            synchronized (lipstick) {
                System.out.println(this.name + "获得口红的锁");
                Thread.sleep(1000);

//                //一秒钟后想获得镜子
                synchronized (mirror) {
                    System.out.println(this.name + "获得镜子的锁");
                }
            }
            //破解死锁
//            synchronized (mirror) {
//                System.out.println(this.name + "获得镜子的锁");
//            }
        } else {
            //获得镜子的锁
            synchronized (mirror) {
                System.out.println(this.name + "获得镜子的锁");
                Thread.sleep(2000);

                //一秒钟后想获得口红
                synchronized (lipstick) {
                    System.out.println(this.name + "获得口红的锁");
                }
            }
             //破解死锁
//            synchronized (lipstick) {
//                System.out.println(this.name + "获得口红的锁");
//            }
        }

    }
}


