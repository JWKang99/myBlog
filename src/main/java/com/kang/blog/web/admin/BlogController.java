package com.kang.blog.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Blog;
import com.kang.blog.entity.User;
import com.kang.blog.service.BlogService;
import com.kang.blog.service.CategoryService;
import com.kang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    private Long userId;

    private void setCategoryAndTag(Model model){
        model.addAttribute("categories",categoryService.getAllCategories(userId));
        model.addAttribute("tags",tagService.getAllTag(userId));
    }

    /**
     * 展示后台管理博客列表
     * @param page 分页工具
     * @param model
     * @param session 用于获取当前登录用户
     * @return
     */
    @GetMapping("/blogs")
    public String list(@RequestParam(required = false, defaultValue = "1", value = "page")int page,
                       Model model,HttpSession session){
        PageHelper.startPage(page,10);

        //从session中拿到当前登录用户的id
        User user = (User)session.getAttribute("user");
        userId = user.getId();

        List<Blog> blogList = blogService.getAllBlogs(userId);
        PageInfo<Blog> blogs = new PageInfo<>(blogList);
        model.addAttribute("blogs",blogs);
        //此处需要获取类型列表，筛选所需
        setCategoryAndTag(model);
        return "admin/blogs";
    }

    /**
     * 后台管理博客 搜索
     * @param page
     * @param blog blog对象里封装了搜索的条件，包括博主的id
     * @param model
     * @return
     */
    @PostMapping("/blogs/search")
    public String search(@RequestParam(required = false,defaultValue = "1",value = "page")int page,
                         Blog blog, Model model){

        //用于筛选当前登录用户的博客列表
        blog.setUserId(userId);
        List<Blog> blogList = blogService.getSearchAdminBlog(blog);
        PageHelper.startPage(page,10);
        PageInfo<Blog> blogs = new PageInfo<>(blogList);
        model.addAttribute("blogs",blogs);
        //返回一个片段
        return "admin/blogs::bloglist";
    }

    //新增博客
    @GetMapping("/blogs/input")
    public String input(Model model){
        setCategoryAndTag(model);
        model.addAttribute("blog",new Blog());
        return "admin/blogs-publish";
    }

    //编辑博客
    @GetMapping("/blogs/{id}/input")
    public String input(@PathVariable Long id, Model model){
        setCategoryAndTag(model);
        //拿到博客详情对象在前端显示出来,markdown未转换
        Blog blog = blogService.getBlog(id);
        blog.init();    //将tags集合转换为tagIds字符串,前端识别字符串1,2,3
        System.out.println(blog);
        model.addAttribute("blog",blog);
        return "admin/blogs-publish";
    }



    /**
     *  新增和修改共用一个post方法
     */
    @PostMapping("/blogs/input")
    public String input(Blog blog, HttpSession session,RedirectAttributes attributes){
        blog.setUser((User)session.getAttribute("user"));
        blog.setUserId(userId);

        //blog.getCategory().getId()对应页面中的category.id
        blog.setCategory(categoryService.getCategory(blog.getCategory().getId()));
        blog.setCategoryId(blog.getCategory().getId());

        //把前端的标签数据[1,2,3]转换为标签列表存到blog对象中
        blog.setTags(tagService.listTag(blog.getTagIds()));

        if(blog.getId()==null){
            System.out.println("进入新发布");
            blogService.saveBlog(blog);
            attributes.addFlashAttribute("message","新增成功");
        }else{
            System.out.println("进入更新");
            blogService.updateBlog(blog);
            attributes.addFlashAttribute("message","更新成功");
        }

        return "redirect:/admin/blogs";
    }


    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }
}
