package com.xiao.mvcStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by knight on 16/12/8.
 */
@Controller
@RequestMapping(value = "/common")
public class LoginController {

    @RequestMapping("/login")
    public String login(String userName,String passWord){
        if(userName ==null || userName ==null){
            return  "login";
        }
        if(userName.equals("admin") && passWord.equals("admin")){
            return  "admin/adminHome";
        }else{
            return  "error";
        }
    }
}
