package aop.project1;

import java.lang.reflect.Proxy;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 9:59
 */
public class AnimalFactory {


    /**
     * 获取对象方法
     */
    private static Object getAnimalBase(Object obj, AopMethod method) {
        Class[] clazz = obj.getClass().getInterfaces();
        for (Class c : clazz) {
            System.out.println("name=" + c.getName());
        }
        // 获取代理对象
        return Proxy
            .newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new AOPHandel(AnnoInjection.getBean(obj), method));
    }

    /**
     * 获取对象方法
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAnimal(Object obj, AopMethod method) {
        return (T) getAnimalBase(obj, method);
    }

    /***
     * 获取对象方法
     * @param className
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAnimal(String className, AopMethod method) {
        Object obj = null;
        try {
            obj = getAnimalBase(Class.forName(className).newInstance(), method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }

    /***
     * 获取对象方法
     * @param clz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAnimal(Class clz, AopMethod method) {
        Object obj = null;
        try {
            obj = getAnimalBase(clz.newInstance(), method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) obj;
    }
}
