package com.xiao.mvcStart.model;

/**
 * Created by knight on 16/12/8.
 */
public class Student {

    public  Student(){

    }
    public Student(int id,String name){
        this.id=id;
        this.name= name;
        this.isChinese = true;
    }

    private int id;
    private String name;
    private boolean isChinese;

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


    public boolean isChinese() {
        return isChinese;
    }

    public void setChinese(boolean chinese) {
        isChinese = chinese;
    }
}
