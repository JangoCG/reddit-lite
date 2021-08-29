package com.jangocg.redditserver.rest.service;

import com.jangocg.redditserver.rest.model.Post;
import com.jangocg.redditserver.rest.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PostService {

    PostRepository postRepository;

    public Optional<Post> getPost(long postId) {
        System.out.println("inside service" + postId);
        return postRepository.findById(postId);
    }

    public Post createPost(String title, String description) {
        Post post = Post.builder().description(title).title(description).build();
        return postRepository.save(post);
    }
}
