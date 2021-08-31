package com.jangocg.redditserver.rest.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String username) {
        super("User " + username + " not found");
    }
}

