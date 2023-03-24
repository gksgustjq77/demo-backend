package com.example.demo.common;


import org.springframework.http.HttpStatus;

import com.example.demo.common.exception.ApiStatus;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApiException  {

    private static final long serialVersionUID = -8832746191965751891L;

    private ApiStatus status;
    private String message;

    public ApiException(ApiStatus status) {
        this.status = status;
        this.message = message;
    }

    public ApiException(ApiStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return status.getHttpStatus();
    }

    public ApiStatus getApiStatus() {
        return status;
    }

    public void setStatus(ApiStatus status) {
        this.status = status;
    }

    public String getCode() {
        return status.getCode();
    }

    public String getMessage() {
        return message;
    }

}
