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
//@Table( uniqueConstraints = { @UniqueConstraint(columnNames = {"user_email"})})
public class Blogs {

    @Id
//    @Column(name = "blog_id")
    private String id;
    private String title;
    private String content;

    @ManyToOne
    private Users user;

    @ManyToMany(mappedBy = "blogs_categories")
    private List<Categories> categories;
    public void addCategory(Categories category){ this.categories.add(category); }
    public void removeCategory(Categories category){
        this.categories.remove(category);
    }

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "blog_id",referencedColumnName = "id")
    private List<Comments> comments;
    public void addComment(Comments comment){
        this.comments.add(comment);
    }
    public void removeComment(Comments comment){
        this.comments.remove(comment);
    }

}
