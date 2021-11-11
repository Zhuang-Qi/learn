package aop.test;

import aop.annotation.MyMethodAnnotation;
import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/27 16:50
 */
public class MyMethodAnnotationTest {

    @Override
    @MyMethodAnnotation(title = "toStringMethod", description = "override toString method")
    public String toString() {
        return "override toString method";
    }

    @Deprecated
    @MyMethodAnnotation(title = "old static method", description = "deprecated old static method")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyMethodAnnotation(title = "test method", description = "suppress warning static method")
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }

    public static void main(String[] args) {
        Method[] methods = MyMethodAnnotationTest.class.getMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyMethodAnnotation.class)) {
                for (Annotation anno : method.getDeclaredAnnotations()) {
                    System.out.println("Annotation in method :" + method + ":" + anno);
                }

                MyMethodAnnotation methodAnno = method.getAnnotation(MyMethodAnnotation.class);
                System.out.println(methodAnno.title());
            }
        }
    }

}
