package com.jangocg.redditserver.rest.service;


import com.jangocg.redditserver.rest.exception.UserAlreadyExistsException;
import com.jangocg.redditserver.rest.exception.UserNotFoundException;
import com.jangocg.redditserver.rest.model.User;
import com.jangocg.redditserver.rest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    /**
     * Get a single user by username.
     *
     * @param username last name of the the user.
     * @return found {@link User}
     */
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    /**
     * Create a single user.
     *
     * @param username
     * @param password
     * @return created user {@link User}
     */
    public User createUser(String username, String password) {

        // check if user already exists
        if (getByUsername(username) != null) {
            throw new UserAlreadyExistsException(username);
        }
        // hash pw
        Argon2PasswordEncoder argon2 = new Argon2PasswordEncoder();
        String hashedPw = argon2.encode(password);

        User user = User.builder()
                .username(username)
                .password(hashedPw)
                .build();

        return userRepository.save(user);
    }
}
