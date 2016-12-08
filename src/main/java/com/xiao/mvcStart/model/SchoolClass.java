package com.xiao.mvcStart.model;

import java.util.List;

/**
 * Created by knight on 16/12/8.
 */
public class SchoolClass {

    public  SchoolClass(int id,String name){
        this.id=id;
        this.name=name;
    }

    private int id;
    private String name;
    private List<Student> studentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
