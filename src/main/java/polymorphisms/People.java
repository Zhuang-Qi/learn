package polymorphisms;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/20 16:58
 */
public class People {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public People(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
            "name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
}
