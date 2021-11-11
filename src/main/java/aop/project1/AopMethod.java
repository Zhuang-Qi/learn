package aop.project1;

import java.lang.reflect.Method;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/28 11:12
 */
public interface AopMethod {
    void after(Object proxy, Method method,Object[] args);
    void before(Object proxy, Method method,Object[] args);

}
