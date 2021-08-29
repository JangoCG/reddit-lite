package com.jangocg.redditserver.rest.controller;

import com.jangocg.redditserver.rest.model.Post;
import com.jangocg.redditserver.rest.model.User;
import com.jangocg.redditserver.rest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        return userService.createUser(user.getLastName(), user.getLastName(), user.getPassword());
    }
}
