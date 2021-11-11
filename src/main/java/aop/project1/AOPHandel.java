package aop.project1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/27 19:50
 */
public class AOPHandel implements InvocationHandler {

    private Object o;
    private AopMethod method;

    public AOPHandel(Object o, AopMethod method) {
        this.o = o;
        this.method = method;
    }

    /**
     * 这个方法会自动调用,Java动态代理机制 会传入下面是个参数
     *
     * @param proxy 代理对象的接口,不同于对象
     * @param method 被调用方法
     * @param args 方法参数 不能使用invoke时使用proxy作为反射参数时,因为代理对象的接口,不同于对象 这种代理机制是面向接口，而不是面向类的
     **/

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法返回值
        Object ret;
        System.out.println("执行方法：" + method.getName());
        if (args != null) {
            System.out.println("参数：" + args[0]);
        }
        // 打印参数
        for (Class type : method.getParameterTypes()) {
            System.out.println(type.getName());
        }
        // 打印返回类型
        System.out.println("返回数据类型：" + method.getReturnType().getName());
        // 反射调用方法
        this.method.before(proxy, method, args);
        ret = method.invoke(o, args);
        this.method.after(proxy, method, args);
        return ret;
    }


}
