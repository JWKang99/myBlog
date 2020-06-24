package com.kang.blog.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Blog;
import com.kang.blog.entity.Category;
import com.kang.blog.entity.Tag;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.CategoryService;
import com.kang.blog.service.CommentService;
import com.kang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/{userId}")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping
    public String index(@RequestParam(required = false,defaultValue = "1",value = "page") int page,
                        @PathVariable Long userId, Model model){
        PageHelper.startPage(page,3);
        List<Blog> blogList = blogService.getIndexBlogByUser(userId);
        PageInfo<Blog> blogs = new PageInfo<Blog>(blogList);
        model.addAttribute("userId",userId);
        model.addAttribute("page",blogs);
        List<Tag> tagList = tagService.getTagsPage(userId);
        List<Category> categoryList = categoryService.getCategoriesPage(userId);
        List<Blog> recommendList = blogService.getRecommendBlogsByUser(userId,4);
        model.addAttribute("categories",categoryList);
        model.addAttribute("tags",tagList);
        model.addAttribute("recommendBlogs",recommendList);
        return "index";
    }

    @GetMapping("/indexBlogs")
    public String indexBlogs(@RequestParam(required = false,defaultValue = "1",value = "page") int page,
                             @PathVariable Long userId,Model model){
        PageHelper.startPage(page,3);
        List<Blog> blogList = blogService.getIndexBlogByUser(userId);
        PageInfo<Blog> blogs = new PageInfo<Blog>(blogList);
        model.addAttribute("page",blogs);
        return "index :: indexBlogs";
    }


    @GetMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "1",value = "page") int page,
                         @PathVariable Long userId,@RequestParam String query,
                         Model model){
        System.out.println(query);
        PageHelper.startPage(page,8);
        List<Blog> blogList = blogService.getSearchBlogByUser(userId,query);
        PageInfo<Blog> blogs = new PageInfo<>(blogList);
        model.addAttribute("page",blogs);
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/footer/blogs")
    public String newBlogs(Model model){
        //model.addAttribute("newblogs",blogService.getRecommendBlogs(3));
        return "_fragment :: newbloglist";
    }

}
