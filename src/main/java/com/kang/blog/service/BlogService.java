package com.kang.blog.service;

import com.kang.blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlog(Long id);

    int countBlog();

    //后端获取博客，不需要转换markdown,这两个方法可以和为一个，在controller层区分转换是否html
    Blog getBlog(Long id);

    //前端展示博客详情,把markdown转换为html,不需要用户信息
    Blog getDetailBlog(Long id);

    //获取所有博客
    List<Blog> getAllBlogs();

    //首页博客列表
    List<Blog> getIndexBlog();

    //首页推荐博客
    List<Blog> getRecommendBlogs(int size);

    //全局搜索
    List<Blog> getSearchBlog(String query);

    //后台搜索博客
    List<Blog> getSearchAdminBlog(Blog blog);

    //根据类型查找blog
    List<Blog> getByCategoryId(Long categoryId);

    //根据标签查询blog
    List<Blog> getByTagId(Long tagId);

    //归档博客<year,blog>
    Map<String, List<Blog>> archiveBlogs();

}
