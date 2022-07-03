package com.barclays.delivery.modal;

import org.springframework.http.HttpStatus;

public class ResponseTemplate {
    private String message;
    private HttpStatus httpStatus;
    private Object data;

    public ResponseTemplate(String message, HttpStatus httpStatus, Object data) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public ResponseTemplate(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
