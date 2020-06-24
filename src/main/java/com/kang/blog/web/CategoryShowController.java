package com.kang.blog.web;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Blog;
import com.kang.blog.entity.Category;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.CategoryService;
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
public class CategoryShowController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/categories/{id}")
    public String categories(@RequestParam(required = false,defaultValue = "1",value = "page")int page, Model model,
                             @PathVariable Long userId,@PathVariable Long id){
        PageHelper.startPage(page,8);
        List<Category> categories = categoryService.getCategoriesPage(userId);
        model.addAttribute("userId",userId);
        if(id==-1){
            //从导航栏进入分类页
            id = categories.get(0).getId();
        }
        List<Blog> blogs = blogService.getByCategoryId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("page",pageInfo);
        model.addAttribute("categories",categories);
        model.addAttribute("activeCategoryId",id);
        return "categories";
    }
}
