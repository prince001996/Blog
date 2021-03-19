package com.prince.blog.service;

import com.prince.blog.entity.Categories;
import com.prince.blog.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        List<Categories> category = categoriesRepository.findAll();
        return category;
    }


    public Categories addCategory(Categories category) {
        Categories category1 = categoriesRepository.save(category);
        return category1;
    }

    public String updateCategory(Categories category) {
        Optional<Categories> category1 = categoriesRepository.findById(category.getId());
        if(category1.isPresent()){
            categoriesRepository.save(category);
            return "Categories Updated";
        }
        return "Repository Error";
    }

    public String deleteCategory(String id) {

        try{
            categoriesRepository.deleteById(id);
            return "Category Deleted";
        }
        catch(Exception e){
            return "Delete category failed";
        }

    }
}
