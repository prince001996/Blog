package com.prince.blog.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @ManyToMany(mappedBy = "categories")
    private List<Blogs> blogs;
    public void addBlog(Blogs blog){
        this.blogs.add(blog);
    }
    public void removeBlog(Blogs blog){
        this.blogs.remove(blog);
    }
}
