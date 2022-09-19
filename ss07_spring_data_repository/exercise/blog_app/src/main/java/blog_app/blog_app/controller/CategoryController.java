package blog_app.blog_app.controller;

import blog_app.blog_app.model.Blog;
import blog_app.blog_app.model.Category;
import blog_app.blog_app.service.IBlogService;
import blog_app.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "list_category";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "create_category";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create blog: " + category.getCategoryName() + " OK!");
        return "redirect:/category";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "edit_category";
    }

    @PostMapping("/update")
    public String update(Category category) {
        categoryService.update(category);
        return "redirect:/category";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "delete_category";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        categoryService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return "redirect:/category";
    }

}
