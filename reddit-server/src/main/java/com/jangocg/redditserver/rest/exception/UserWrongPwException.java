package com.jangocg.redditserver.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UserWrongPwException extends RuntimeException {
    public UserWrongPwException() {
        super("Wrong password");
    }
}
