package com.inorg.payload;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiSuccessPayload {

    String message;
    int statusCode;
    String httpStatus;
    boolean success;
    boolean exception;
    LocalDateTime timestamp;
    Object body;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isException() {
        return exception;
    }

    public void setException(boolean exception) {
        this.exception = exception;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public ApiSuccessPayload(String message, int statusCode, String httpStatus, boolean success, boolean exception, LocalDateTime timestamp, Object body) {
        this.message = message;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
        this.success = success;
        this.exception = exception;
        this.timestamp = timestamp;
        this.body = body;
    }

    public ApiSuccessPayload() {
    }

    public static ApiSuccessPayload build(Object body, HttpStatus status, String message){
        ApiSuccessPayload payload=new ApiSuccessPayload();
        payload.setMessage(message);
        payload.setBody(body);
        payload.setHttpStatus(status.name());
        payload.setStatusCode(status.value());
        payload.setTimestamp(LocalDateTime.now());
        payload.setSuccess(true);
        payload.setException(false);

        return payload;
    }




}
