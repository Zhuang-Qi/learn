package aop.project1;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/27 19:49
 */
public class DogImp implements AnimalInterface {

    @Seven(value = "Lumia")
    private String name ;

    private String property;

    @Override
    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("getName");
        return this.name;
    }

    @Override
    public void say() {
        System.out.println("dog:汪汪汪。。。");
    }

    @Override
    @Seven(property = "牛逼")
    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public void getProperty() {
        System.out.println(this.name+this.property);
    }

}
