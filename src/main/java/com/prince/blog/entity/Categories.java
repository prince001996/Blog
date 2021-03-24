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
public class Categories {
    @Id
    @Column(name = "category_id")
    private String id;
    private String category_name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "blogs_categories", joinColumns = {@JoinColumn(name = "category_id")}, inverseJoinColumns = {@JoinColumn(name = "blog_id")})
    private List<Blogs> blogs_categories;
    public void addBlog(Blogs blog){
        this.blogs_categories.add(blog);
    }
    public void removeBlog(Blogs blog){
        this.blogs_categories.remove(blog);
    }
}
