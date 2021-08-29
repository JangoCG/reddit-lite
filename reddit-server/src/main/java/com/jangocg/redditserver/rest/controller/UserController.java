package com.jangocg.redditserver.rest.controller;

import com.jangocg.redditserver.rest.exception.UserAlreadyExistsException;
import com.jangocg.redditserver.rest.exception.UserNotFoundException;
import com.jangocg.redditserver.rest.model.User;
import com.jangocg.redditserver.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    UserService userService;

    /**
     * Create a single user.
     *
     * @param user The user to be created.
     * @return created {@link User}
     */
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user.getUsername(), user.getPassword());
    }

    /**
     * Get a user by username.
     *
     * @param username user name of the user.
     * @return found {@link User}
     */
    @GetMapping("/username/{username}")
    public User getUser(@PathVariable("username") String username) {
        User user = Optional
                .ofNullable(userService.getByUsername(username))
                .orElseThrow(() -> new UserNotFoundException(username));
        return user;
    }
}
