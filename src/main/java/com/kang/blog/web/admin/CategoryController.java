package com.kang.blog.web.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kang.blog.entity.Category;
import com.kang.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String getCategories(@RequestParam(required = false,defaultValue = "1",value = "page") int page, Model model){
        List<Category> categories = categoryService.getAllCategories();

        PageHelper.startPage(page,8);

        PageInfo<Category> pageInfo = new PageInfo<>(categories);

        model.addAttribute("categoriesList",pageInfo);
        return "admin/categories";
    }
    @GetMapping("/categories/input")
    public String inputCategory(Model model){
        //给前端th:object返回一个对象
        model.addAttribute("category",new Category());
        return "admin/category-publish";
    }

    /**
     *  新增分类
     */
    @PostMapping("/categories")
    public String postCategory(Category category, RedirectAttributes attributes){
        Category c = categoryService.getCategoryByName(category.getName());
        if(c!=null){
            attributes.addFlashAttribute("message","该分类已存在");
            return "redirect:/admin/categories/input";
        }
        int res = categoryService.saveCategory(category);
        if(res>0){
            attributes.addFlashAttribute("message","新增成功");
        }else{
            attributes.addFlashAttribute("message","新增失败");
        }
        //重定向之后会显示tag数据,因为经过了/admin/tags下的方法
        //若直接定位admin/tags直接返回html页面没经过数据查询
        return "redirect:/admin/categories";
    }
    @GetMapping("/categories/{id}/input")
    public String editInput(@PathVariable Long id, Model model){
        Category c = categoryService.getCategory(id);
        model.addAttribute("category",c);
        System.out.println(c);
        return "admin/category-publish";
    }
    @GetMapping("/categories/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        Category c = categoryService.getCategory(id);
        categoryService.deleteCategory(id);
        System.out.println(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/categories";
    }

    /**
     *  编辑分类
     */
    @PostMapping("/categories/{id}")
    public String editCategory(@Valid Category category, BindingResult result, @PathVariable Long id, RedirectAttributes attributes){
        Category c = categoryService.getCategoryByName(category.getName());
        if(c!=null){
            attributes.addFlashAttribute("message","分类名称未改变");
            return "redirect:/admin/categories/"+id+"/input";
        }
        if(result.hasErrors()){
            return "admin/category-publish";
        }

        int res = categoryService.updateCategory(category);
        if(res>0){
            attributes.addFlashAttribute("message","更新成功");
        }else{
            attributes.addFlashAttribute("message","更新失败");
        }
        //重定向之后会显示tag数据,因为经过了/admin/tags下的方法
        //若直接定位admin/tags直接返回html页面没经过数据查询
        return "redirect:/admin/categories";
    }


}
