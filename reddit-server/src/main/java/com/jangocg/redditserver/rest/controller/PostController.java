package com.jangocg.redditserver.rest.controller;

import com.jangocg.redditserver.rest.model.Post;
import com.jangocg.redditserver.rest.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    /**
     * Get a single post.
     *
     * @param id ID of the the post.
     * @return found {@link Post}
     */
    @GetMapping
    public Optional<Post> getPost(@RequestParam(name = "id", required = true) long id) {
        //        ResponseEntity<String> response = new ResponseEntity<>("Hello World", HttpStatus.BAD_REQUEST);
        System.out.println(id);
        return postService.getPost(id);
    }

    /**
     * Create a single post.
     *
     * @param post The post to be created.
     * @return created {@link Post}
     */
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        System.out.println(post.getDescription());
        System.out.println(post.getTitle());
        return postService.createPost(post.getTitle(), post.getDescription());
    }
}
