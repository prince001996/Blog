package com.prince.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Users {

    @Id
    private String email;
    private String name;
    private String mobile;
    private String password;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "user_email",referencedColumnName = "email")
    private List<Blogs> blogs;
    public void addBlog(Blogs blog){
        this.blogs.add(blog);
    }
    public void removeBlog(Blogs blog){
        this.blogs.remove(blog);
    }


    @ManyToMany(mappedBy = "users_comments")
    private List<Comments> comments;
    public void addComment(Comments comment){
        this.comments.add(comment);
    }
    public void removeComment(Comments comment){
        this.comments.remove(comment);
    }

}
