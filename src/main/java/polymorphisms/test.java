package polymorphisms;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/20 17:00
 */
public class test {

    public static void main(String[] args) {
        Peo p = new Peo();
        Student s = new Student("zhangsan","13","abcd");
        p.setP(s);
        Student s1= (Student) p.getP();
        System.out.println(s1.getSchool());
    }

}
