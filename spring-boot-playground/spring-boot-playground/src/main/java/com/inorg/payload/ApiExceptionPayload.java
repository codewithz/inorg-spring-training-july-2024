package com.inorg.payload;

import java.time.LocalDateTime;

public class ApiExceptionPayload {

    String message;
    int statusCode;
    String httpStatus;
    boolean success;
    boolean exception;
    LocalDateTime timestamp;
    String path;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ApiExceptionPayload(String message, int statusCode, String httpStatus, boolean success, boolean exception, LocalDateTime timestamp, String path) {
        this.message = message;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
        this.success = success;
        this.exception = exception;
        this.timestamp = timestamp;
        this.path = path;
    }
}
