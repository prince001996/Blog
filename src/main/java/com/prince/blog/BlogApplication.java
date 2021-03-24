package com.prince.blog;

import com.prince.blog.entity.Blogs;
import com.prince.blog.repository.BlogsRepository;
import com.prince.blog.service.BlogsService;
import com.prince.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
//@EnableWebSecurity
public class BlogApplication {

//    @Autowired
//    BlogsService blogsService;
//    @Autowired
//    UsersService usersService;

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

//    @Transactional
//    @Override
//    public void run(String... args) throws Exception {
//        blogsService.getAllBlogsByUser("prince@email");
//    }
}
