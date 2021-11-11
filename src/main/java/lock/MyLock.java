package lock;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/14 10:54
 */

/**
 * 不可重入锁
 */
public class MyLock {

    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true; // 线程第一次进入后就会将器设置为true，第二次进入是就会由于where true进入死循环
    }

    public synchronized void unlock() {
        isLocked = false; /// 将这个值设置为false目的是释放锁
        notify(); // 结束阻塞

    }

}
