package com.example.webservice.v1.core.exception;

import com.example.webservice.v1.core.result.Result;
import com.example.webservice.v1.core.utilites.Message;
import com.example.webservice.v1.core.utilites.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(NotUniqueValues.class)
    public ResponseEntity<Result> notUniqueValues() {
        return new ResponseEntity<>(ResultHelper.NOT_UNIQUE(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<Result> notFoundIdException() {
        return new ResponseEntity<>(ResultHelper.NOT_FOUND(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<Result> authorizationException() {
        return new ResponseEntity<>(ResultHelper.NOY_YOUR_ID(),HttpStatus.BAD_REQUEST);
    }
}
