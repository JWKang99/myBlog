package com.kang.blog.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Blog;
import com.kang.blog.entity.Tag;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@RequestParam(required = false,defaultValue = "1",value = "page") int page, Model model,
                             @PathVariable Long id){
        List<Tag> tags = tagService.getIndexTags();
        if(id==-1){
            //从导航栏进入分类页
            id = tags.get(0).getId();
        }
        List<Blog> blogList = blogService.getByTagId(id);
        PageHelper.startPage(page,8);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        model.addAttribute("tags",tags);
        model.addAttribute("page",pageInfo);
        model.addAttribute("activeTagId",id);
        return "tags";
    }
}
