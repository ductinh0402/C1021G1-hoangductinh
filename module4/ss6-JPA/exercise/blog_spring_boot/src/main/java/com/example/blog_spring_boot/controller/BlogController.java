package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Blog;

import com.example.blog_spring_boot.services.IBlogService;
import com.example.blog_spring_boot.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;


@Controller
@RequestMapping(value = {"","/blog"})
public class BlogController {

    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String listBlog(@PageableDefault(size = 1) Pageable pageable, Model model ) {
        Page<Blog> blogPage = iBlogService.findAll(pageable);
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blogList", blogPage);
        return "/list";
    }

    @GetMapping("/create")
    public String createBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());

        return "/create";
    }

    @PostMapping("/add")
    public String saveBlog(@ModelAttribute("blog") Blog blog) {
        blog.setDate(new Date());
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") Integer id) {
        iBlogService.deleteById(id);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    @ResponseBody
    public ModelAndView editBlog(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/update");
        modelAndView.addObject("blog", iBlogService.findById(id).get());
        Blog blog = iBlogService.findById(id).get();
        int categoryId = blog.getCategories().getId();
        modelAndView.addObject("categoryId", categoryId);
        modelAndView.addObject("categoryList", iCategoryService.findAll());
        return modelAndView;
    }
   @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog){
       blog.setDate(new Date());
        iBlogService.save(blog);
        return "redirect:/blog";
   }
   @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Integer id,Model model){
       model.addAttribute("blog",iBlogService.findById(id).get()) ;
      return "/view";
   }
   @GetMapping("/search")
    public String searchBlog(@RequestParam("kq") String name,@PageableDefault(size = 3) Pageable pageable,Model model){
        Page<Blog> blogPage=iBlogService.search(name,pageable);
        model.addAttribute("blogList",blogPage);
        return "/list";
   }

}
