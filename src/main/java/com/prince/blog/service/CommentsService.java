package com.prince.blog.service;

import com.prince.blog.entity.Blogs;
import com.prince.blog.entity.Comments;
import com.prince.blog.entity.Users;
import com.prince.blog.repository.BlogsRepository;
import com.prince.blog.repository.CommentsRepository;
import com.prince.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {

    @Autowired
    CommentsRepository commentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    BlogsRepository blogsRepository;

    public String addComment(Comments comment, String email, String blogId) {
        Comments comment1 = commentsRepository.save(comment);

        Optional<Users> user = usersRepository.findById(email);
        Optional<Blogs> blog = blogsRepository.findById(blogId);
        user.get().addComment(comment1);
        usersRepository.save(user.get());
        blog.get().addComment(comment1);
        blogsRepository.save(blog.get());
        return "Comment added to blog with id - " + blogId + " by user with id - " + email;
    }

    public List<Comments> getAll() {
        return commentsRepository.findAll();
    }

//    public void associateUser(String email, Comments comment) {
//        Optional<Users> user = usersRepository.findById(email);
////        Comments comment = commentsRepository.findById(commentId).get();
//        user.get().addComment(comment);
//    }
//
//    public void associateBlog(String blogId, Comments comment) {
//        Optional<Blogs> blog = blogsRepository.findById(blogId);
//
//        blog.get().addComment(comment);
//
//    }
}
