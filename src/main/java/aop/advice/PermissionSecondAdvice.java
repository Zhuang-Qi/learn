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
 * @since 2021/1/7 16:01
 */
@Aspect
@Component
@Order(0)
public class PermissionSecondAdvice {

    @Pointcut("@annotation(aop.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckSecond(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("======第二个切面========");

        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id------------->" + id);
        System.out.println("name----------->" + name);

        if(!name.equals("admin")){
            return JSON.parseObject("{\"message\":\"no permisson\",\"code\":401}");
        }
        return joinPoint.proceed();
    }
}
