package com.prince.blog.service;

import com.prince.blog.entity.Blogs;
import com.prince.blog.entity.Categories;
import com.prince.blog.repository.BlogsRepository;
import com.prince.blog.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    BlogsRepository blogsRepository;

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

    public String associateCategory(String blogId, String categoryId) {

        //get the category
        Optional<Categories> category = categoriesRepository.findById(categoryId);

        if(category.isPresent()){
            //get the blog
            Optional<Blogs> blog = blogsRepository.findById(blogId);
            if(blog.isPresent()){
                blog.get().addCategory(category.get());

                category.get().addBlog(blog.get());

                blogsRepository.save(blog.get());
//                categoriesRepository.save(category.get());

                return "Blog and category successfully updated";
            }
            else{
                return "No blog found";
            }
        }
        else{
            return "Category not found";
        }




    }
}
