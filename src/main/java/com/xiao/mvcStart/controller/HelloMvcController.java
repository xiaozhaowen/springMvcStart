package com.xiao.mvcStart.controller;

import com.xiao.mvcStart.model.SchoolClass;
import com.xiao.mvcStart.model.Student;
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
 * Created by knight on 16/12/7.
 */

@Controller
@RequestMapping("/hello")
public class HelloMvcController {

    /**
     *    http://host:8080/hello/greeting
     *    拦截到这样输入时,会呈现home.jsp
     * */
    @RequestMapping("/greeting")
    public  String greeting(){
        return  "home";
    }


    /**
     *  http://localhost:8080/hello/login
     *
     *  注解中的value地址栏的请求url,另一种书写方式
     * */
    @RequestMapping(value = "/login")
    public String login(){
        return  "login";
    }


    /**
     *      http://localhost:8080/hello/say?age=120
     * */
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @ResponseBody
    public String say( Integer age){
        System.out.println("param age is " + age);
        return "Age is " +age;
    }


    /**
     *      http://localhost:8080/hello/getStudent
     *
     * */
    @RequestMapping("/getStudent")
    public ResponseEntity<Student> getStudentById(){
        Student student = new Student();
        student.setId(1);
        student.setName("Stephen Curry");
        ResponseEntity<Student> result = new ResponseEntity<Student>(student, HttpStatus.OK);
        return  result;
    }


    /**
     * http://localhost:8080/hello/getClass?id=12
     * */
    @RequestMapping("/getClass")
    public ResponseEntity<SchoolClass> getClass(@RequestParam("id") int classId){
        System.out.println("******班级id是"+classId);
        SchoolClass schoolClass = new SchoolClass(1,"红旗班");

        Student s1 = new Student();
        s1.setId(1);
        s1.setName("张三");

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("库里");


        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);


        schoolClass.setStudentList(list);
        return new ResponseEntity<SchoolClass>(schoolClass,HttpStatus.OK);

    }









}
