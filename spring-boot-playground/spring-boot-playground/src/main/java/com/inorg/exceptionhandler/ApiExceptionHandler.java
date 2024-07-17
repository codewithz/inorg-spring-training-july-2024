package com.inorg.exceptionhandler;

import com.inorg.payload.ApiExceptionPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ResponseStatusException.class)
    public ResponseEntity<ApiExceptionPayload> handleApiException(
            ResponseStatusException exception, WebRequest webRequest){

        String path=webRequest.getDescription(true);
//        1. Create the payload
        ApiExceptionPayload payload=new ApiExceptionPayload(
                exception.getMessage(),
                exception.getStatusCode().value(),
                String.valueOf(exception.getStatusCode()),
                false,
                true,
                LocalDateTime.now(),
                path
        );
//        2. Return the ResponseEntity

        ResponseEntity<ApiExceptionPayload> response=new ResponseEntity<>(payload,exception.getStatusCode());
        return response;

    }

}
