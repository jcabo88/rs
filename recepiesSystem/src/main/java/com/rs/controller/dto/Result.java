package com.rs.controller.dto;

public class Result {
    Object result;

    public Result(Object result) {
        this.result = result;
    }

    public Result(){
        this.result = new Object();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
