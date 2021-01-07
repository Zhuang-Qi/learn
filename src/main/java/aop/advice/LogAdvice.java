package aop.advice;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/1/7 11:36
 */
@Aspect
@Component
public class LogAdvice {
    // 定义一个切点，所有被GetMapping注解修饰的方法会织入advice
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut(){}

    // Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
        System.out.println("get请求的advice触发了");
    }
}
