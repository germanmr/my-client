package com.mycompany.myclient.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Nonnull;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

@RestControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public GenericError handle(@Nonnull RuntimeException e) {
        requireNonNull(e);
        String errorCode = UUID.randomUUID().toString();
        return new GenericError(errorCode, "A runtime Exception has occurred!");
    }

    @ExceptionHandler(NoClientsFoundException.class)
    public GenericError handleNoClientsException(@Nonnull NoClientsFoundException e) {
        requireNonNull(e);
        String errorCode = UUID.randomUUID().toString();
        return new GenericError(errorCode, "We didn´t find any clients!");
    }

    @ExceptionHandler(NoClientFoundException.class)
    public GenericError handleNoClientFoundException(@Nonnull NoClientFoundException e) {
        requireNonNull(e);
        String errorCode = UUID.randomUUID().toString();
        return new GenericError(errorCode, "We didn´t find any client!");
    }


}
