package zach.venusrestblog.controller;

import org.springframework.web.bind.annotation.*;
import zach.venusrestblog.data.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/posts", headers = "Accept=application/json")
public class PostsController {
    //catching all posts
    private List<Post> posts = new ArrayList<>();
    //setting up IDs for incrementing
    private long postID = 1;


    //Get all for the /posts endpoint
    @GetMapping
    private List<Post> getAllPosts(){
        return posts;
    }

    //Get by ID using PathVariable
    @GetMapping("{id}")
    public Post getPostByID(@PathVariable long id){
        //iterate to reach correct post
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getId() == id){
                return posts.get(i);
            }
        }
        return null;
    }
    //Create a new post
    @PostMapping("")
    public void createPost(@RequestBody Post newPost){
        newPost.setId(postID);
        postID++;
        posts.add(newPost);
    }

    //Delete a post by ID
    @DeleteMapping("/{id}")
    public void deletePostByID(@PathVariable long id) {
        Post postToDelete = getPostByID(id);

        if(postToDelete != null){
            posts.remove(postToDelete);
            return;
        }

        throw new RuntimeException("Post could not be found.");
    }

    //Update title or content for post by ID
    @PutMapping("/{id}")
    public void updatePost(@RequestBody Post updatedPost, @PathVariable long id){

        Post postToUpdate = getPostByID(id);

        if(postToUpdate == null){
            System.out.println("Post not found!");
        } else {

            if(updatedPost.getTitle() != null) {
                postToUpdate.setTitle(updatedPost.getTitle());
            }

            if(updatedPost.getContent() != null){
                postToUpdate.setContent(updatedPost.getContent());
            }

            return;
        }
        throw new RuntimeException("Post not found.");
    }
}