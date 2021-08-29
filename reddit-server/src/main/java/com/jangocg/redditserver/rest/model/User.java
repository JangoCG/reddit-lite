package com.jangocg.redditserver.rest.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
// user is a reserved keyword in PostgreSQL. It is allowed only as quoted identifier. So "users" is
// used as table name.
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
