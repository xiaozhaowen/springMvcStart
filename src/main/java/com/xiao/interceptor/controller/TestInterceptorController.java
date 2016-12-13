package com.xiao.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by knight on 16/12/13.
 */
@Controller
@RequestMapping("/interceptor")
public class TestInterceptorController {
    @RequestMapping(value = "/login")
    @ResponseBody
    public String hello(){
        return  "admin/login";
    }


    @RequestMapping("/home")
    public ModelAndView viewAll(){
        ModelAndView modelAndView = new ModelAndView("admin/adminHome");
        modelAndView.addObject("adminName","Administrator");
        return  modelAndView;
    }
}
