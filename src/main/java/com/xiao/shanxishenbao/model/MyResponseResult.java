package com.xiao.shanxishenbao.model;

/**
 * Created by knight on 16/12/12.
 */
public class MyResponseResult {
    private int code;
    private String message;
    private Object content;

    public MyResponseResult(int code, String message, Object content) {
        this.code = code;
        this.message = message;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
