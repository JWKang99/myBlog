package com.kang.blog.web;


import com.kang.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{userId}")
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archive(@PathVariable Long userId, Model model){
        model.addAttribute("archiveMap",blogService.archiveBlogsByUser(userId));
        model.addAttribute("blogCount",blogService.countBlogByUser(userId));
        return "archives";
    }
}
