package com.mycompany.myclient.exceptions;

public class NoClientFoundException extends RuntimeException {

    public NoClientFoundException() {
    }

    public NoClientFoundException(String message) {
        super(message);
    }

}
