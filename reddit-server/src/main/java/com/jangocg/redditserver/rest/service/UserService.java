package com.jangocg.redditserver.rest.service;


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
     * Get a single user by id.
     * @param id the id of the user.
     * @return found {@link User}
     */
    public Optional<User> getById(UUID id) {
        return userRepository.findById(id);
    }

    /**
     * Create a single user.
     *
     * @param firstName
     * @param lastName
     * @param password
     * @return created user {@link User}
     */
    public User createUser(String firstName, String lastName, String password) {
        Argon2PasswordEncoder argon2 = new Argon2PasswordEncoder();
        String hashedPw = argon2.encode(password);
        System.out.println("hashed pw" + hashedPw);
        User user = User.builder().firstName(firstName).lastName(lastName).password(hashedPw).build();
        return userRepository.save(user);
    }

}
