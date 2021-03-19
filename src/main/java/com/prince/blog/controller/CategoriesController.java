package com.prince.blog.controller;


import com.prince.blog.entity.Categories;
import com.prince.blog.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class CategoriesController {


    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/categories")
    public List<Categories> getAllCAtegories(){
        List<Categories> categoriesInfo = categoriesService.getAllCategories();
        return categoriesInfo;
    }

    @PostMapping("/category")
    public Categories addCategory(@RequestBody Categories category){
        Categories category1 = categoriesService.addCategory(category);
        return category1;
    }

    @PutMapping("/category")
    public String updateCategory(@RequestBody Categories category){
        String msg = categoriesService.updateCategory(category);
        return msg;
    }

    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable("id") String id){
        String msg = categoriesService.deleteCategory(id);
        return msg;
    }



}
