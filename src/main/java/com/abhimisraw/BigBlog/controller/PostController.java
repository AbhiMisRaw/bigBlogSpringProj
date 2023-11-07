package com.abhimisraw.BigBlog.controller;

import com.abhimisraw.BigBlog.domain.Post;
import com.abhimisraw.BigBlog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/add")
    public String addPost(Model model){
        model.addAttribute("post", new Post());
        return "addPost";
    }



    @PostMapping("/save")
    public String addPost(@ModelAttribute("post") @Valid Post post , Errors errors, Model model){
        if (errors.hasErrors()){
            System.out.println("Data has some error....");
            return "addPost";
        }
        System.out.println("Data is going to save....");
        postService.addPost(post);
        System.out.println("Data is saved....");
        return "redirect:/post/all";
    }


    @GetMapping("/all")
    public String getAllPost(Model model){
        //postService
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

//
//    @GetMapping("/edit")
//    public String editPost(@RequestParam Long postId, Model model) {
//        // Retrieve a Post object from the database or another source
//        Post post = postService.getPostById(postId);
//
//        // Add the Post object to the model with the name "post"
//        model.addAttribute("post", post);
//
//        return "editPostForm";
//    }



}
