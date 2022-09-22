package book_management.controller;

import book_management.model.Book;
import book_management.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("bookList", new Book());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("bookList", "Add new successful!!");
        return "redirect:/book";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("bookList", iBookService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) throws Exception {
        Book book = iBookService.findById(id);
        if (book.getAmount() == 0) {
            throw new Exception();
        } else {
            model.addAttribute("bookList", book);
            return "/edit";
        }
    }

    @PostMapping("/edit")
    public String updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount() - 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "successfully borrowed the book!");
        return "redirect:/book";
    }

    @GetMapping("/{id}/pay")
    public String update(@PathVariable int id, Model model) {
        Book book = iBookService.findById(id);
        model.addAttribute("bookList", book);
        return "pay";
    }

    @PostMapping("/update")
    public String payBook(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(id);
        book.setAmount(book.getAmount() + 1);
        iBookService.save(book);
        redirectAttributes.addFlashAttribute("message", "successfully returned the book!");
        return "redirect:/book";
    }
}