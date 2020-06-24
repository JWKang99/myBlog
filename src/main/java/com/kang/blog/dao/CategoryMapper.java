package com.kang.blog.dao;

import com.kang.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    //删除分类,返回值为int
    int deleteById(Long id);

    //保存新的分类
    int saveCategory(Category category);

    //更新已有分类
    int updateCategory(Category category);

    //此方法用于判断是否有重复的分类名
    Category findByName(String name);

    //通过id查找分类
    Category findById(Long id);

    //分页查找所有分类
    List<Category> findAllCategories(Long userId);

    //首页展示分类
    List<Category> getIndexCategories();

    List<Category> getCategoriesPage(Long userId);


}
