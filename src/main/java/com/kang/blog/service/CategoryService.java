package com.kang.blog.service;

import com.kang.blog.entity.Category;

import java.util.List;

public interface CategoryService {

    int saveCategory(Category category);

    Category getCategory(Long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    List<Category> getIndexCategories();

    int updateCategory(Category category);

    int deleteCategory(Long id);

}
