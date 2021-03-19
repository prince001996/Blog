//package com.prince.blog.entity;
//
//
//import lombok.*;
//
//import javax.persistence.*;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
//@Table( uniqueConstraints = { @UniqueConstraint( columnNames = {"blog_id"})})
//public class BlogCategories {
//
//    @OneToOne
//    @JoinColumn(name = "blog_id")
//    private String blogId;
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private String categoryId;
//
//}
