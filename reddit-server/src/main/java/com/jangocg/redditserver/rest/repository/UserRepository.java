package com.jangocg.redditserver.rest.repository;

import com.jangocg.redditserver.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Find a user by his last name.
     *
     * @param username username of the user
     * @return Optional of the {@link User}
     */
    Optional<User> findByUsername(String username);
}
