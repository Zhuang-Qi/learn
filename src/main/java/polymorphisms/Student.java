package polymorphisms;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/4/20 16:58
 */
public class Student extends People{

    private String school;

    public Student(String name, String age, String school) {
        super(name, age);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
            "school='" + school + '\'' +
            '}';
    }
}
