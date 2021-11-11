package aop.project1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 13:47
 */
public class AnnoInjection {

    public static Object getBean(Object obj) {
        try {
            // 获得类属性
            Field f[] = obj.getClass().getDeclaredFields();
            for (Field ff : f) {
                // 获得属性上的注解
                Seven s = ff.getAnnotation(Seven.class);
                if (s != null) {
                    System.out.println("注入" + ff.getName() + "属性" + "\t" + s.value());
                    // 反射调用public set方法，如果未访问级别private,那么可以直接使用属性的set(obj,value)
                    obj.getClass()
                        .getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1),
                            new Class[]{String.class}).invoke(obj, s.value());
                }
            }
            // 获得所有方法
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method mm : m) {
                Seven s = mm.getAnnotation(Seven.class);
                if (s != null) {
                    System.out.println("注入" + mm.getName() + "方法" + "\t" + s.property());
                    mm.invoke(obj, s.property());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

}
