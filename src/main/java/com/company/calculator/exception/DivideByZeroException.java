package com.company.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;


public class DivideByZeroException extends IllegalArgumentException{
    public DivideByZeroException() {
    }

    public DivideByZeroException(String s) {
        super(s);
    }

    public DivideByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideByZeroException(Throwable cause) {
        super(cause);
    }

}
