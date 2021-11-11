package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/2/26 14:36
 */
public class Constructors {

    public static void main(String[] args)
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("reflect.Student");

        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] pcons = clazz.getConstructors();
        for (Constructor c : pcons) {
            System.out.println(c);
        }
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor[] acons = clazz.getDeclaredConstructors();
        for (Constructor c : acons) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法*******************************");
        Constructor constructor = clazz.getDeclaredConstructor(String.class, Integer.class);
        System.out.println(constructor);

        constructor.newInstance("zhangsan", 18);

        System.out.println("************获取所有公有的字段********************");

        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("************获取所有的字段********************");
        Field[] fields1 = clazz.getDeclaredFields();
        for (Field f : fields1) {
            System.out.println(f);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field f = clazz.getField("number");
        System.out.println(f);
        Object o = clazz.getConstructor().newInstance();
        f.set(o, 9990);
        System.out.println(((Student) o).getNumber());


    }

}
