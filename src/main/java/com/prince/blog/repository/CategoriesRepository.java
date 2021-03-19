package com.prince.blog.repository;

import com.prince.blog.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, String> {

    
}
