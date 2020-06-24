package com.kang.blog.service.impl;

import com.kang.blog.dao.CategoryMapper;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.entity.Category;
import com.kang.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public int saveCategory(Category category) {
        return categoryMapper.saveCategory(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryMapper.findById(id);
    }

    @Override
    public List<Category> getAllCategories(Long userId) {
        return categoryMapper.findAllCategories(userId);
    }

    @Override
    public List<Category> getIndexCategories() {
        return categoryMapper.getIndexCategories();
    }

    @Override
    public List<Category> getCategoriesPage(Long userId) {
        return categoryMapper.getCategoriesPage(userId);
    }

    @Override
    public int updateCategory(Category category) {
        Category findRes = categoryMapper.findById(category.getId());
        if(findRes == null){
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(category,findRes);
        return categoryMapper.updateCategory(findRes);
    }

    @Override
    @Transactional
    public int deleteCategory(Long id) {
        return categoryMapper.deleteById(id);
    }


    @Override
    public Category getCategoryByName(String name) {
        return categoryMapper.findByName(name);
    }
}
