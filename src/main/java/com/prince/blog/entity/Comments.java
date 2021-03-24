package com.prince.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "blogs_comments", joinColumns = {@JoinColumn(name = "comment_id")}, inverseJoinColumns = {@JoinColumn(name = "blog_id")})
    private List<Blogs> blogs_comments;
    public void addBlog(Blogs blog){
        this.blogs_comments.add(blog);
    }
    public void removeBlog(Blogs blog){
        this.blogs_comments.remove(blog);
    }

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "users_comments", joinColumns = {@JoinColumn(name = "comment_id")}, inverseJoinColumns = {@JoinColumn(name = "email")})
    private List<Users> users_comments;
    public void addUser(Users user){
        this.users_comments.add(user);
    }
    public void removeUser(Users user){
        this.users_comments.remove(user);
    }

}
