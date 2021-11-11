package aop.project1;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 10:17
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class AopTest {

    @Test
    public void Test1() {
        AnimalInterface dog = AnimalFactory.getAnimal(DogImp.class, new AopMethod() {
                @Override
                public void after(Object proxy, Method method, Object[] args) {
                    System.out.println("成功拦截" + method.getName() + "方法，结束");
                }

                @Override
                public void before(Object proxy, Method method, Object[] args) {
                    if(method.getName().equals("getProperty")){
                        System.out.println("成功拦截" + method.getName() + "方法，开始");
                    }
                }

            }
        );
        dog.say();
        String name1 = "小狗的名字是：" + dog.getName();
        System.out.println(name1);
        dog.setName("哈士奇");
        String name2 = "小狗的名字是：" + dog.getName();
        System.out.println(name2);
        dog.getProperty();
    }

}
