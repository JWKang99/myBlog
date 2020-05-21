package com.kang.blog.dao;

import com.kang.blog.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    int saveBlogTag(Long blogId,Long tagId);

    int deleteBlogTagByBlogId(Long id);

    int updateViews(Long id);

    Blog getBlog(Long id);  //后台展示博客

    Blog getDetailBlogById(Long id);

    List<Blog> getAllPublished();

    List<Blog> getAllBlogs();

    //后台条件搜索
    List<Blog> getSearchAdminBlog(Blog blog);

    //全局搜索博客
    List<Blog> getSearchBlogs(String query);

    List<Blog> getRecommendBlogs(int size);

    List<Blog> getByCategoryId(Long categoryId);

    List<Blog> getByTagId(Long tagId);

    //查询所有年份
    List<String> findGroupYear();

    //按年份搜索博客
    List<Blog> findByYear( String year);

    //主页博客列表
    List<Blog> getIndexBlog();



}
