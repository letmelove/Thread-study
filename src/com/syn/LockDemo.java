package com.syn;


import java.util.concurrent.locks.ReentrantLock;

/**
 * lock是显示锁（手动开启和关闭锁）synchronized是隐式锁，出了作用域自动释放
 * lock只有代码块锁，synchronized有代码块锁和方法锁
 * 使用lock锁，JVM将花费较少的时间来调度线程，性能更好，并具有更好的扩展性（提供更多的子类）
 * 优先顺序：lock>synchronized代码块>synchronized方法
 */
public class LockDemo {
    public static void main(String[] args) {
        TestLock tl=new TestLock();

        new Thread(tl,"小明").start();
        new Thread(tl,"小李").start();
        new Thread(tl,"小嫣").start();
    }
}

class TestLock implements Runnable{

    private int ticketNum=10;
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                Thread.sleep(500);
                if(ticketNum>0){
                    System.out.println(Thread.currentThread().getName()+"拿到了第:"+ticketNum--+"张票");
                }else{
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

}