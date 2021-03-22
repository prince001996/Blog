package com.prince.blog.service;

import com.prince.blog.entity.Blogs;
import com.prince.blog.entity.Users;
import com.prince.blog.repository.BlogsRepository;
import com.prince.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BlogsService {

    @Autowired
    BlogsRepository blogsRepository;

    @Autowired
    UsersRepository usersRepository;


    public List<Blogs> getAllBlogs(){
        List<Blogs> blogs = blogsRepository.findAll();
        return blogs;
    }

    public List<Blogs> getAllBlogsByUser(String email){
        //get the user from email
        Users user = usersRepository.findById(email).get();
        // get all the blogs by user
        System.out.println(user.getBlogs().get(0).getContent());
        List<Blogs> blogs = user.getBlogs();
        return blogs;
    }

    public Blogs addBlog(Blogs blog) {
        Blogs blog1 = blogsRepository.save(blog);
        return blog1;
    }

    public String updateBlog(Blogs blog) {
        //get the blog
        Optional<Blogs> blog1 = blogsRepository.findById(blog.getId());
        if(blog1.isPresent()){

            blog1.get().setId(blog.getId());
            blog1.get().setTitle(blog.getTitle());
            blog1.get().setContent(blog.getContent());
//            blog1.get().setUserEmail(blog.getUserEmail());

            blogsRepository.save(blog1.get());

            return "Blog Updated";
        }
        return "Repository Error";
    }


    public String deleteBlog(String id) {
        // get the blog
        Blogs blog = blogsRepository.findById(id).get();
        try{
            blogsRepository.delete(blog);
            return "Blog deleted";
        }
        catch(Exception e){
            return "Couldn't delete the blog";
        }
    }

    public Blogs allocateUser(String id, String email) {

        Blogs blog = blogsRepository.findById(id).get();
        //check if user exists in the db
        Optional<Users> user1 = usersRepository.findById(email);
        if(user1.isPresent()){
//            blog.setUser(user1.get());

            user1.get().addBlog(blog);
            blogsRepository.save(blog);
            return blog;
        }
        return blog;
    }
}
