package com.prince.blog.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table( uniqueConstraints = { @UniqueConstraint(columnNames = {"user_email"})})
public class Blogs {

    @Id
    private String id;
    private String title;
    private String content;

    @OneToOne
    @JoinColumn(name = "user_email")
    private Users user;

}
