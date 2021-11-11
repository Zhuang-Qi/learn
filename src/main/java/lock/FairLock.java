package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/14 14:26
 */

public class FairLock implements Runnable {

    // new ReentrantLock(true);为公平锁
    // new ReentrantLock(flase);为非公平锁
    public static ReentrantLock fairLock = new ReentrantLock(true);

    public void run() {
        while (true) {
            try {
                fairLock.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "，获得锁!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "线程1");
        Thread t2 = new Thread(fairLock, "线程2");
        t1.start();
        t2.start();
    }
}

