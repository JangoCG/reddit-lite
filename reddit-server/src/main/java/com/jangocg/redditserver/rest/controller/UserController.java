package com.jangocg.redditserver.rest.controller;

import com.jangocg.redditserver.rest.model.User;
import com.jangocg.redditserver.rest.service.UserService;
import lombok.AllArgsConstructor;
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
        return userService.createUser(user.getFirstName(), user.getLastName(), user.getPassword());
    }

    /**
     * Get a user by id.
     *
     * @param id of the user.
     * @return found {@link User}
     */
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") UUID id) {
        //        ResponseEntity<String> response = new ResponseEntity<>("Hello World", HttpStatus.BAD_REQUEST);
        System.out.println(id);
        Optional<User> res = userService.getById(id);
        return res;
    }
}
