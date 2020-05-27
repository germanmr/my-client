package com.mycompany.myclient.exceptions;

public class NoClientsFoundException extends RuntimeException {

    public NoClientsFoundException() {
    }

    public NoClientsFoundException(String message) {
        super(message);
    }

}
