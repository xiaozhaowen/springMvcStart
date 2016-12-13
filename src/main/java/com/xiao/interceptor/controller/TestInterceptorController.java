package com.xiao.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by knight on 16/12/13.
 */
@Controller
@RequestMapping("/interceptor")
public class TestInterceptorController {
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return  "Hello World";
    }
}
