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

    //获取所有已发布的博客，统计总博客数
    List<Blog> getAllPublishedByUser(Long userId);

    List<Blog> getAllBlogs(Long userId);

    //后台条件搜索
    List<Blog> getSearchAdminBlog(Blog blog);

    //全局搜索博客
    List<Blog> getSearchBlogs(String query);

    //搜索当前博主博客
    List<Blog> getSearchBlogsByUser(Long userId,String query);

    List<Blog> getRecommendBlogs(int size);

    List<Blog> getByCategoryId(Long categoryId);

    List<Blog> getByTagId(Long tagId);

    //查询所有年份
    List<String> findGroupYear();

    //按年份搜索博客
    List<Blog> findByYear(String year);

    //查询所有年份,根据指定博主
    List<String> findGroupYearByUser(Long userId);

    //按年份搜索博客,根据指定博主
    List<Blog> findByYearByUser(Long userId,String year);

    //主页博客列表,暂时不用
    List<Blog> getIndexBlog();

    //主页展示已发布博客列表
    List<Blog> getIndexBlogByUser(Long userId);

    //获取对应博主的首页推荐博客
    List<Blog> getRecommendBlogsByUser(Long userId,int size);

}
