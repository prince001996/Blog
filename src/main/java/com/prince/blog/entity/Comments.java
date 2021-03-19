package com.prince.blog.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comments {
    @Id
    private String id;
    private String blogId;
    private String content;


}
