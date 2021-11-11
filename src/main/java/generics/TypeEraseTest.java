package generics;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/21 17:09
 */
public class TypeEraseTest {


    public static void main(String[] args)
        throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        test1();
        test2();
    }

    private static void test1() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(123);
        ArrayList list = new ArrayList<String>();
        list.add(2);
        System.out.println(list);

        System.out.println(list1.getClass() == list2.getClass()); // true
    }

    private static void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

        list.getClass().getMethod("add", Object.class).invoke(list, "asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
