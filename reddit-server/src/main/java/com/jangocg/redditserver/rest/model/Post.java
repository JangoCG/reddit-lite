package com.jangocg.redditserver.rest.model;



import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

}
