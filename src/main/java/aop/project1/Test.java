package aop.project1;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 11:44
 */
public class Test {

    public static void main(String[] args) {
        DogImp dogImp = new DogImp();
        System.out.println(dogImp.getName());
        dogImp.getProperty();
    }

}
