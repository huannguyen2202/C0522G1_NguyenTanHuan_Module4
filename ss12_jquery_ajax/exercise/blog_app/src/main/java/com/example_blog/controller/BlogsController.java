package com.example_blog.controller;


import com.example_blog.model.Blogs;
import com.example_blog.service.IBlogsService;
import com.example_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogsController {

    @Autowired
    private IBlogsService iBlogsService;

    @Autowired
    private ICategoryService iCategoryService;
//    @GetMapping("")
//    public String showBlogs(@PageableDefault(value = 3) Pageable pageable, Model model) {
//        model.addAttribute("blogs", iBlogsService.findAll(pageable));
//        return "list";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoryList",iCategoryService.findAll());
        model.addAttribute("blogs", new Blogs());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blogs blogs, RedirectAttributes redirectAttributes) {
        iBlogsService.save(blogs);
        redirectAttributes.addFlashAttribute("masseNew", "successfully added new !!");
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blogs blogs, RedirectAttributes redirectAttributes) {
        iBlogsService.update(blogs);
        redirectAttributes.addFlashAttribute("messa", "edit successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "blog/delete";
    }

    @PostMapping("/delete")
    public String delete(Blogs blogs, RedirectAttributes redirect) {
        iBlogsService.remove(blogs.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogs", iBlogsService.findById(id));
        return "blog/view";
    }
    @GetMapping("")
    public String search(@RequestParam(value = "name",defaultValue = "") String name,@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("blogs", iBlogsService.findByTitleName(name,pageable));
        model.addAttribute("name",name);
        return "blog/list";
    }
    @GetMapping("/title")
    public String showList(Model model){
        model.addAttribute("blogDto", iBlogsService.showList());
        return "blog/list1";
    }

}
