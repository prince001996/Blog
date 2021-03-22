package com.prince.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comments {
    @Id
    @Column(name = "comment_id")
    private String id;
    private String content;

    @ManyToMany
    @JoinTable(name = "blogs_comments", joinColumns = {@JoinColumn(name = "comment_id")}, inverseJoinColumns = {@JoinColumn(name = "blog_id")})
    private List<Blogs> blogs;
    public void addBlog(Blogs blog){
        this.blogs.add(blog);
    }
    public void removeBlog(Blogs blog){
        this.blogs.remove(blog);
    }

    @ManyToMany
    @JoinTable(name = "blogs_comments", joinColumns = {@JoinColumn(name = "comment_id")}, inverseJoinColumns = {@JoinColumn(name = "email")})
    private List<Users> users;
    public void addUser(Users user){
        this.users.add(user);
    }
    public void removeUser(Users user){
        this.users.remove(user);
    }

}
