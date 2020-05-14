package com.kang.blog.web;


import com.kang.blog.po.Category;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.CategoryService;
import com.kang.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryShowController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/categories/{id}")
    public String categories(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                         Pageable pageable, Model model,
                             @PathVariable Long id){
        List<Category> categories = categoryService.listCategoryTop(10000);
        if(id==-1){
            //从导航栏进入分类页
            id = categories.get(0).getId();
        }
        BlogQuery blogQuery = new BlogQuery();
        blogQuery.setCategoryId(id);
        model.addAttribute("categories",categories);
        model.addAttribute("page",blogService.listBlog(pageable,blogQuery));
        model.addAttribute("activeCategoryId",id);
        return "categories";
    }
}
