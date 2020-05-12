package com.kang.blog.service.impl;

import com.kang.blog.dao.CategoryRepository;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.po.Category;
import com.kang.blog.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    @Transactional
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Page<Category> listCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Category updateCategory(Long id, Category category) {
        Category findRes = categoryRepository.getOne(id);
        if(findRes == null){
            throw new NotFoundException("该类型不存在");
        }
        BeanUtils.copyProperties(category,findRes);
        return categoryRepository.save(findRes);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> listCategoryTop(Integer size) {
        //按照blogs.size降序
        Sort sort = Sort.by(Sort.Order.desc( "blogs.size"));
        Pageable pageable = PageRequest.of(0, size, sort);
        return categoryRepository.findTop(pageable);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
