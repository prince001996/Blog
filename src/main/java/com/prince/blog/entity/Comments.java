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
//    @Column(name = "comment_id")
    private String id;
    private String content;

    @ManyToOne
    private Blogs blog;

    @ManyToOne
    private Users user;

}
