package aop.test;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/7/27 16:22
 */
public class RetentionTest {

    @SourcePolicy
    public void sourcePolicy() {
    }

    @ClassPolicy
    public void classPolicy() {
    }

    @RuntimePolicy
    public void runtimePolicy() {
    }
}
