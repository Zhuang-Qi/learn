package lock;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/14 11:13
 */
public class MyReentrantLock {

    private boolean isLocked = false; // 默认没有上锁
    private Thread lockedBy = null; // 记录阻塞线程
    private int lockedCount = 0; // 上锁次数记录

    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        // 上锁了 并且 如果是同一个线程则放行，否则其它线程需要进入where循环进行等待
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true; // 第一次进入就进行上锁
        lockedBy = thread; // 当前阻塞线程
        lockedCount++; // 上次上锁次数加1
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == this.lockedBy) {
            lockedCount--; // 将上锁次数减一
            if (lockedCount == 0) { // 当计数为0，说明所有线程都释放了锁
                isLocked = false; // 真正的将释放了所有锁
                notify();
            }
        }
    }

}
