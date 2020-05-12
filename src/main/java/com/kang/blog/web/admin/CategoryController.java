package com.kang.blog.web.admin;


import com.kang.blog.po.Category;
import com.kang.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public String getCategories(@PageableDefault(size = 10,sort = {"id"},direction = Sort.Direction.DESC)
                                            Pageable pageable, Model model){
        model.addAttribute("categoriesList",categoryService.listCategory(pageable));
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
    public String postCategory(@Valid Category category, BindingResult result, RedirectAttributes attributes,Model model){
        if(categoryService.getCategoryByName(category.getName())!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if(result.hasErrors()){
            return "admin/category-publish";
        }

        Category reCategory = categoryService.saveCategory(category);
        if(reCategory == null){
            attributes.addFlashAttribute("message","新增失败");
        }else{
            attributes.addFlashAttribute("message","新增成功");
        }
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
    public String editCategory(@Valid Category category, BindingResult result, @PathVariable Long id, RedirectAttributes attributes,Model model){
        if(categoryService.getCategoryByName(category.getName())!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if(result.hasErrors()){
            return "admin/category-publish";
        }
        Category reCategory = categoryService.updateCategory(id,category);
        if(reCategory == null){
            attributes.addFlashAttribute("message","更新失败");
        }else{
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/categories";
    }


}
