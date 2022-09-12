package zach.venusrestblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zach.venusrestblog.data.Post;

import java.util.List;

@RestController
@RequestMapping(value = "/posts", headers = "Accept=application/json")
public class PostsController {
    //Get all for the /posts endpoint
    @GetMapping
    private List<Post> getAllPosts(){

    }

    //Get by ID using PathVariable
    @GetMapping("{id}")
    public Post getPostByID(@PathVariable long id){

    }
}