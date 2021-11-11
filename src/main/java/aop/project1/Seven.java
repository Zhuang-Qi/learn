package aop.project1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 11:36
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Seven {

    String value() default "小黑";

    String property() default "";

}
