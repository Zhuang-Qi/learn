package lock;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/14 11:05
 */

/**
 * 可重入锁示例(同一个线程可以重入上锁的代码段，不同的线程则需要进行阻塞) java的可重入锁有:ReentrantLock（显式的可重入锁）、synchronized（隐式的可重入锁）
 *
 * 可重入锁诞生的目的就是防止上面不可重入锁的那种情况，导致同一个线程不可重入上锁代码段。
 *
 * 目的就是让同一个线程可以重新进入上锁代码段。
 *
 * 设计可重入锁的示例代码
 */

public class ReentrantLockCount {

    MyReentrantLock lock = new MyReentrantLock();

    public void method1() throws InterruptedException {
        lock.lock();
        System.out.println("执行method2方法之前");
        method2();
        lock.unlock();

    }

    public void method2() throws InterruptedException {
        lock.lock();
        System.out.println("执行method2方法中");
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        new ReentrantLockCount().method1();
    }
}

