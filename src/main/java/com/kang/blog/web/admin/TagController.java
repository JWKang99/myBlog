package com.kang.blog.web.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Tag;
import com.kang.blog.entity.User;
import com.kang.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    private Long userId;

    @GetMapping("/tags")
    public String getTags(@RequestParam(required = false, defaultValue = "1", value = "page") int page,
                          Model model, HttpSession session){
        //param1:页码,param2:每页数据数量
        PageHelper.startPage(page,20);
        //调用service获取tag列表
        User user = (User)session.getAttribute("user");
        userId = user.getId();
        List<Tag> tags = tagService.getAllTag(userId);
        //将列表转为分页对象
        PageInfo<Tag> pageInfo = new PageInfo<>(tags);
        model.addAttribute("tagsList",pageInfo);
        return "admin/tags";
    }

    @GetMapping("/tags/input")
    public String inputCategory(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");
        userId = user.getId();
        //给前端th:object返回一个对象
        model.addAttribute("tag",new Tag());
        return "admin/tag-publish";
    }

    /**
     * 新增标签
     */
    @PostMapping("/tags")
    public String postCategory(Tag tag, RedirectAttributes attributes){
        Tag t = tagService.getTagByName(userId,tag.getName());
        if(t!=null){
            attributes.addFlashAttribute("message","该标签已存在");
            return "redirect:/admin/tags/input";
        }
        System.out.println(userId);
        tag.setUserId(userId);
        int res = tagService.saveTag(tag);
        if(res>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }
        //重定向之后会显示tag数据,因为经过了/admin/tags下的方法
        //若直接定位admin/tags直接返回html页面没经过数据查询
        return "redirect:/admin/tags";
    }
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        model.addAttribute("tag",tagService.getTag(id));
        return "admin/tag-publish";
    }

    /**
     * 编辑更新标签
     */
    @PostMapping("/tags/{id}")
    public String editTag(@PathVariable Long id, Tag tag, RedirectAttributes attributes, Model model){
        Tag t = tagService.getTagByName(userId,tag.getName());
        if(t!=null){
            attributes.addFlashAttribute("message","标签名未改变");
            return "redirect:/admin/tags/"+id+"/input";
        }
        int res = tagService.updateTag(id,tag);
        if(res>0){
            attributes.addFlashAttribute("message","更新成功");
        }else{
            attributes.addFlashAttribute("message","更新失败");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        tagService.deleteTag(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/tags";
    }
}
