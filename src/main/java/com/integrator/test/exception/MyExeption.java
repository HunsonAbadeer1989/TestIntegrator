package com.integrator.test.exception;

public class MyExeption extends RuntimeException{

    public MyExeption(String message){
        super(message);
    }

    public MyExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
