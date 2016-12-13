package com.xiao.shanxishenbao.model;

/**
 * Created by knight on 16/12/12.
 */
public class TaxType {

    public TaxType() {
    }

    public TaxType(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    private int id;
    private String code;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
