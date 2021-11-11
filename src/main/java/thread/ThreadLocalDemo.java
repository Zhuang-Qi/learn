package thread;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/5/12 15:45
 */
public class ThreadLocalDemo {

    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {//启动三个线程
            Thread t = new Thread(ThreadLocalDemo::add10ByThreadLocal);
            t.start();
        }
    }

    /**
     * 线程本地存储变量加 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
    }

}
