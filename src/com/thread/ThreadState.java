package com.thread;

/**
 * 观察线程状态
 * 线程状态说明：
 *           NEW：尚未启动的线程处于此状态。
 *           RUNNABLE: 在Java虚拟机中执行的线程处于此状态。
 *           BLOCKED: 被阻塞等待监视器锁定的线程处于此状态。
 *           WAITING: 正在等待另一个线程执行特定动作的线程处于此状态
 *           TIMED_WAITING: 正在等待另一个线程执行动作达到指定等待时间的线程处于此状态。
 *           TERMINATED: 已退出的线程处于此状态。
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("run......");

        });

        //观察状态
        Thread.State state = thread.getState();//获取线程状态
        System.out.println(state); //new

        //启动状态
        thread.start();
        state = thread.getState();
        System.out.println(state);//Runnable

        // TERMINATED:已退出的线程处于此状态。
        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            //更新线程状态
            state = thread.getState();
            System.out.println(state);
        }
    }

}
