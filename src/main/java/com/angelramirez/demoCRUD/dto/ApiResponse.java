package com.angelramirez.demoCRUD.dto;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {

    private Integer status;
    private String message;
    private Object result;


    public ApiResponse(Integer status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
