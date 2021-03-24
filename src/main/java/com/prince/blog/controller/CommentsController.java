package com.prince.blog.controller;


import com.prince.blog.entity.Blogs;
import com.prince.blog.entity.Comments;
import com.prince.blog.entity.Users;
import com.prince.blog.repository.BlogsRepository;
import com.prince.blog.repository.UsersRepository;
import com.prince.blog.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BlogsRepository blogsRepository;

    @PostMapping("/comments/{email}/{blogId}")
    public String addComment(@PathVariable("email") String email, @PathVariable("blogId") String blogId, @RequestBody Comments comment){
        Comments comment1 = commentsService.addComment(comment);
//        commentsService.associateUser(email, comment1);
        commentsService.associateBlog(blogId, comment1);

        return "Comment added to blog with id - " + blogId + " by user with id - " + email;
    }


}
