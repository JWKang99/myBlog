package com.kang.blog.service.impl;

import com.kang.blog.dao.BlogMapper;
import com.kang.blog.entity.Tag;
import com.kang.blog.exception.NotFoundException;
import com.kang.blog.entity.Blog;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.TagService;
import com.kang.blog.utils.MarkDownUtils;
import com.kang.blog.utils.String2List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;


@Service
public class BlogServiceImpl implements BlogService {


    private BlogMapper blogMapper;

    @Autowired
    private TagService tagService;

    public BlogMapper getBlogMapper() {
        return blogMapper;
    }

    @Autowired
    public void setBlogMapper(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    //仅获取后台管理列表所需属性
    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlog(id);
    }

    @Override
    public Blog getDetailBlog(Long id) {
        Blog blog = blogMapper.getDetailBlogById(id);
        if(blog==null){
            throw new NotFoundException("该博客不存在");
        }
        blogMapper.updateViews(id);
        String content = blog.getContent();
        String html = MarkDownUtils.markdownToHtmlExtensions(content);
        blog.setContent(html);
        return blog;
    }

    @Override
    public List<Blog> getAllBlogs(Long userId) {
        return blogMapper.getAllBlogs(userId);
    }

    @Override
    public List<Blog> getIndexBlog() {
        return blogMapper.getIndexBlog();
    }

    @Override
    public List<Blog> getIndexBlogByUser(Long userId) {
        return blogMapper.getIndexBlogByUser(userId);
    }

    /**
     * 全局模糊搜索，查询标题和详情中的内容
     * @param query 查询的内容
     */
    @Override
    public List<Blog> getSearchBlog(String query) {
        return blogMapper.getSearchBlogs(query);
    }

    @Override
    public List<Blog> getSearchBlogByUser(Long userId, String query) {
        return blogMapper.getSearchBlogsByUser(userId,query);
    }

    @Override
    public List<Blog> getSearchAdminBlog(Blog blog) {
        return blogMapper.getSearchAdminBlog(blog);
    }

    @Override
    public List<Blog> getByCategoryId(Long categoryId) {
        return blogMapper.getByCategoryId(categoryId);
    }

    @Override
    public List<Blog> getByTagId(Long tagId) {
        return blogMapper.getByTagId(tagId);
    }

    @Override
    public Map<String, List<Blog>> archiveBlogs() {
        //获取所有博客的年份
        List<String> years = blogMapper.findGroupYear();
        for(String year : years){
            System.out.println(year);
        }
        Map<String, List<Blog>> map = new HashMap<>();
        for(String year : years){
            List<Blog> blogs = blogMapper.findByYear(year);
            map.put(year,blogs);
        }
        return map;
    }

    @Override
    public Map<String, List<Blog>> archiveBlogsByUser(Long userId) {
        //获取所有博客的年份
        List<String> years = blogMapper.findGroupYearByUser(userId);
        for(String year : years){
            System.out.println(year);
        }
        Map<String, List<Blog>> map = new HashMap<>();
        for(String year : years){
            List<Blog> blogs = blogMapper.findByYearByUser(userId,year);
            map.put(year,blogs);
        }
        return map;
    }

    @Override
    public int countBlogByUser(Long userId) {
        return blogMapper.getAllPublishedByUser(userId).size();
    }

    @Override
    public int countBlog() {
        return blogMapper.getAllPublished().size();
    }

    @Override
    @Transactional
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        //mybatis新增数据后会自动把自增的id复制给blog.id
        blogMapper.saveBlog(blog);
        Long blog_id = blog.getId();
        //需手动把tag和blog的对应关系存到blog_tag表中
        List<Tag> tags = blog.getTags();
        //将博客和标签的对应关系存储到中间表
        for(Tag tag : tags){
            //逐一保存到t_blog_tag表中
            blogMapper.saveBlogTag(blog.getId(),tag.getId());
        }
        return 1;
    }

    @Override
    @Transactional
    public int updateBlog(Blog blog) {
        Blog findRes = blogMapper.getBlog(blog.getId());
        if(findRes == null){
            throw new NotFoundException("该博客不存在");
        }

        blog.setUpdateTime(new Date());
        //先删除原来的博客标签关联关系
        blogMapper.deleteBlogTagByBlogId(blog.getId());
        List<Tag> tags = blog.getTags();
        for(Tag tag : tags){
            //逐一保存到t_blog_tag表中
            blogMapper.saveBlogTag(blog.getId(),tag.getId());
        }
        return blogMapper.updateBlog(blog);
    }

    @Override
    @Transactional
    public int deleteBlog(Long id) {

        return blogMapper.deleteBlog(id)+blogMapper.deleteBlogTagByBlogId(id);
    }


    @Override
    public List<Blog> getRecommendBlogs(int size) {
        return blogMapper.getRecommendBlogs(size);
    }

    @Override
    public List<Blog> getRecommendBlogsByUser(Long userId, int size) {
        return blogMapper.getRecommendBlogsByUser(userId,size);
    }
}
