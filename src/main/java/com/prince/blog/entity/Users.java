package com.prince.blog.entity;

import lombok.*;

import javax.persistence.*;

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

//    @JoinColumn(name = "email")
//    @OneToOne
//    Blogs blog;

}
