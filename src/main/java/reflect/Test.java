package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/5/18 11:39
 */
public class Test {


    public static void main(String[] args)
        throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> klass = methodClass.class;
        //创建methodClass的实例
        Object obj = klass.newInstance();
        //获取methodClass类的add方法
        Method method = klass.getMethod("add", int.class, int.class);
        //调用method对应的方法 => add(1,4)
        Object result = method.invoke(obj, 1, 4);
        System.out.println(result);
    }
}

class methodClass {

    public final int fuck = 3;

    public int add(int a, int b) {
        System.out.println("a:" + a + ",b:" + b);
        return a + b;
    }
    public int sub(int a, int b) {
        return a + b;
    }
}

