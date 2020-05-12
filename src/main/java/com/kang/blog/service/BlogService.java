package com.kang.blog.service;

import com.kang.blog.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kang.blog.vo.BlogQuery;

import java.util.List;

public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blogQuery);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

    List<Blog> listRecommendBlogTop(Integer size);


}
