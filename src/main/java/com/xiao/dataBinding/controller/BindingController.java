package com.xiao.dataBinding.controller;

import com.xiao.dataBinding.model.StringWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by knight on 16/12/10.
 *
 * 讲述如何绑定数据类型,主要是用于采集数据。request方面
 */

@Controller
@RequestMapping("/binding")
public class BindingController {



    /**
     * http://localhost:8080/binding/primitiveType?age=10
     * 地址栏的请求地址是大小写敏感的.
     *
     *
     *          参数默认要求是必须传递的,如果不传递的话会服务器会报500的错误
     *          如果参数传空或者错误数据类型的则会报400的错误
     *
     * */
    @RequestMapping(value = "/primitiveType")
    @ResponseBody
    public String primitiveTypeInt(int age){
        return "age :"+age;
    }


    /**
     *  地址栏格式:http://localhost:8080/binding/integer?age=
     *  地址栏格式:http://localhost:8080/binding/integer?age=100
     *
     *  但是数据类型也得是正确的
     * */
    @RequestMapping(value = "/integer")
    @ResponseBody
    public String primitiveTypeInteger(Integer age){
        return "age :"+age;
    }



    /**
     *
     *  http://localhost:8080/binding/getName?name=James
     *  http://localhost:8080/binding/getName?name=1&my_age=100
     *  http://localhost:8080/binding/getName?name=张三&my_age=100
     *  但是如果传递汉字的话,则会出现乱码,解决办法是在web.xml文件中配置一个过滤器设定字符编码方式,可以解决请求的汉字问题
     *
     *  但是数据类型也得是正确的
     * */
    @RequestMapping(value = "/getName",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
//    @ResponseBody
    public ResponseEntity<String> primitiveTypeString(String name, @RequestParam(value = "my_age",required = false,defaultValue = "10") int age){
      System.out.println("**** name :"+name);
//        return "输入是name :"+name +"and age is "+age;
        String result = "输入是name :"+name +"and age is "+age;
        System.out.println(result);
        return  new ResponseEntity<String>(result, HttpStatus.OK);
    }


    /**
     * 如果直接返回字符串的话则默认使用 StringHttpMessageConverter
     * 而 StringHttpMessageConverter 使用的默认编码为东欧字符 ISO-8859-1
     * */
    @RequestMapping(value = "/china",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public  String getChinese(){
        System.out.println("控制器的getChinese 方法执行");
        return "天龙八部";
    }


    /** 这里使用了一个集合来包装一下String也不会出现汉字乱码*/
    @RequestMapping(value = "/china_list")
    @ResponseBody
    public List<String> getChineseList(){
       return  new ArrayList<String>(){{
           add("中国人");
           add("英国人");
       }};

//        List<String> result = new ArrayList<String>();
//        result.add("河北省");
//        result.add("河南省");
//        return  result;

    }




    /** 这里使用了一个类来包装一下String也不会出现汉字乱码*/
    @RequestMapping(value = "/get_wrapper")
    @ResponseBody
    public StringWrapper getChineseWrapper(){
        return  new StringWrapper("射雕英雄传");
    }










}
