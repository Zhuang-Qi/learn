package lock;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/14 11:05
 */

/**
 * 不可重入锁示例(同一个线程不可以重入上锁后的代码段)
 * 如下是一个不可重入锁的逻辑过程，会发现执行main方法控制台会打印执行doJob方法前，然后就会一直线程阻塞，不会打印执行doJob方法过程中，
 * 原因在于第一次上锁后，由于没有释放锁，因此执行第一次lock后isLocked = true，这个时候调用doJob()内部又一次调用了lock()
 * 由于上个线程将isLocked = true，导致再次进入的时候就进入死循环。导致线程无法执行System.out.println("执行doJob方法过程中");
 * 这行代码，因此控制台只能打印执行doJob方法前。这种现象就造成了不可重入锁
 *
 */

public class LockCount {

    MyLock lock = new MyLock();

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
        new LockCount().method1();
    }

}
