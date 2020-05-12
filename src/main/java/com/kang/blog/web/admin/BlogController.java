package com.kang.blog.web.admin;

import com.kang.blog.po.Blog;
import com.kang.blog.po.User;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.CategoryService;
import com.kang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vo.BlogQuery;

import javax.servlet.http.HttpSession;
import java.util.Stack;


@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT = "admin/blogs-publish";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";


    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/blogs")
    public String list(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC)
                                   Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("blogs",blogService.listBlog(pageable,blog));
        return LIST;
    }
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 8,sort = {"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog,
                         Model model){
        model.addAttribute("blogs",blogService.listBlog(pageable,blog));
        //返回一个片段
        return "admin/blogs::bloglist";
    }

    private void setCategoryAndTag(Model model){
        model.addAttribute("categories",categoryService.listCategory());
        model.addAttribute("tags",tagService.listTag());
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        setCategoryAndTag(model);
        model.addAttribute("blog",new Blog());
        return INPUT;
    }

    @GetMapping("/blogs/{id}/input")
    public String input(@PathVariable Long id, Model model){
        setCategoryAndTag(model);
        //数据库blog表中没有存储tagsId字段，需要处理
        Blog blog = blogService.getBlog(id);
        blog.init();
        System.out.println(blog);
        model.addAttribute("blog",blog);
        return INPUT;
    }



    /**
     *  新增和修改共用一个方法
     */
    @PostMapping("/blogs/input")
    public String input(Blog blog, HttpSession session,RedirectAttributes attributes){
        blog.setUser((User)session.getAttribute("user"));
        //blog.getCategory().getId()对应页面中的category.id
        blog.setCategory(categoryService.getCategory(blog.getCategory().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));
        Blog saveRes;
        if(blog.getId()==null){
            System.out.println("进入新发布");
            saveRes = blogService.saveBlog(blog);
        }else{
            System.out.println("进入更新");
            saveRes = blogService.updateBlog(blog.getId(),blog);
        }
        if(saveRes==null){
            attributes.addFlashAttribute("message","操作失败");
        }else{
            attributes.addFlashAttribute("message","操作成功");
        }
        return REDIRECT_LIST;
    }


    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return REDIRECT_LIST;
    }
}
