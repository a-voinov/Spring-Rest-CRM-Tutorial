package com.tutorial.springdemo.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String s) {
        super(s);
    }

    public CustomerNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CustomerNotFoundException(Throwable throwable) {
        super(throwable);
    }

    protected CustomerNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

}
