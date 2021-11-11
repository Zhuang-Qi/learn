package reflect;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/2/26 10:56
 */
public class Student {

    public Integer number;

    private String name;

    private Integer age;

    public Student() {
        System.out.println("无参构造器");
    }

    public Student(String name, Integer age) {
        System.out.println("name:" + name + "年龄：" + age);
    }

    public Student(String name) {
        System.out.println("学生姓名：" + name);
    }

    protected Student(Integer age) {
        System.out.println("受保护的方法：age");
    }

    private Student(Boolean b) {
        System.out.println("私有方法：" + b);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}
