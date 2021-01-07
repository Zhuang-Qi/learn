package aop.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/1/7 15:10
 */
@Aspect
@Component
@Order(1)
public class PermissionFirstAdvice {

    //定义一个切面，括号内为自定义注解路径
    @Pointcut("@annotation(aop.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======第一个切面=======");

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id1------------->" + id);
        System.out.println("name1------------>" + name);

        if(id<0){
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }
        return joinPoint.proceed();
    }
}
