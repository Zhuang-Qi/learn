package aop.controller;

import aop.annotation.PermissionAnnotation;
import aop.project1.Seven;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (c) 2020/6/1-present, Sinovatio Corporation. All rights reserved.
 *
 * @author zhuangqi
 * @since 2021/1/7 14:07
 */
@RestController
@RequestMapping(value = "/aop")
public class AopController {

    @GetMapping(value = "/getTest")
    public String aopTest(){
        return "hello world!";
    }

    @PostMapping("/permission")
    @PermissionAnnotation()
    public JSONObject getGroupList( @RequestBody JSONObject request){
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }
}
