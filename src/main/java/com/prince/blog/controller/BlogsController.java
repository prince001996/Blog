package com.prince.blog.controller;


import com.prince.blog.entity.Blogs;
import com.prince.blog.entity.Users;
import com.prince.blog.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class BlogsController {

    @Autowired
    BlogsService blogsService;

    @GetMapping("/blogs")
    public List<Blogs> getAllBlogs(){
        List<Blogs> blogs = blogsService.getAllBlogs();
        return  blogs;
    }

    @GetMapping("/blogs/{email}")
    public List<Blogs> getAllBlogsByUser(@PathVariable("email") String email){
        List<Blogs> blogs = blogsService.getAllBlogsByUser(email);
        return  blogs;
    }

    @PostMapping("/blog/{id}/{email}")
    public Blogs allocateUser(@PathVariable("id") String id, @PathVariable("email") String email){
        // fetch the Blogs object
        Blogs blog1 = blogsService.allocateUser(id, email);
        // set the value
        return blog1;
    }

    @PostMapping("/blog")
    public Blogs addBlog(@RequestBody Blogs blog){
        Blogs blog1 = blogsService.addBlog(blog);
        return blog1;
    }


    @PutMapping("/blog")
    public String updateBlog(@RequestBody Blogs blog){
        String msg = blogsService.updateBlog(blog);
        return msg;
    }

    @DeleteMapping("/blog/{id}")
    public String deleteUser(@PathVariable("id") String id){
        String msg = blogsService.deleteBlog(id);
        return msg;
    }

}
