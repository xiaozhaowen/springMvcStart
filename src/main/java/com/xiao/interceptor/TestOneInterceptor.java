package com.xiao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by knight on 16/12/13.
 */
public class TestOneInterceptor implements HandlerInterceptor {


    /**
     * 在进入控制器之前执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o 请求的目标控制器
     *
     * @return 如果返回false的话将会中断执行,并且不会进入到控制器中
     */
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("TestOneInterceptor 的 preHandle 执行");
        return true;
    }


    /**
     * 从控制器执行完毕之后将执行此方法,我们可以对控制器返回的结果做一些额外的操作。
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView 控制器方法返回的ModelAndView。
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("TestOneInterceptor 的 postHandle 执行");

        //修改控制器返回的字段值
        modelAndView.addObject("adminName","超级管理员");
        //修改控制器返回的页面,重定向
        modelAndView.setViewName("admin/login");

    }


    /**
     * 拦截器执行完毕,一般用于释放资源,比如:关闭连接,释放流等
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("TestOneInterceptor 的 afterCompletion 执行");
    }
}
