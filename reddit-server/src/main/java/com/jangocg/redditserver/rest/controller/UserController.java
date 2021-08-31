package com.jangocg.redditserver.rest.controller;

import com.jangocg.redditserver.rest.exception.UserNotFoundException;
import com.jangocg.redditserver.rest.model.User;
import com.jangocg.redditserver.rest.model.dto.LoginDto;
import com.jangocg.redditserver.rest.service.UserService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    UserService userService;

    /**
     * Register a user.
     *
     * @param user The user to be created.
     * @return created {@link User}
     */
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user.getUsername(), user.getPassword());
    }

    /**
     * Get a user by username.
     *
     * @param username user name of the user.
     * @return found {@link User}
     */
    @GetMapping("/username/{username}")
    public User getUser(@PathVariable("username") String username) throws UserNotFoundException {
        Optional<User> optionalUser = userService.getByUsername(username);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException(username);
        }
    }

    /**
     * Login
     *
     * @param loginDto Dto containing information to verify the user
     * @return Username of the succesfully logged-in user.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@NotNull @RequestBody LoginDto loginDto) throws UserNotFoundException {
        return ResponseEntity.of(Optional.of(userService.verifyUser(loginDto)));
    }
}
