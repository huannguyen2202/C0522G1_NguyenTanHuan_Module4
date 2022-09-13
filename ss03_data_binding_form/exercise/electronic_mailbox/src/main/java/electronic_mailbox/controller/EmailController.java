package electronic_mailbox.controller;

import electronic_mailbox.model.Email;
import electronic_mailbox.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public ModelAndView showList() {
        return new ModelAndView("list", "emailList", iEmailService.findAll());
    }

    @GetMapping("/update")
    public String home(@RequestParam int id, Model model) {
        model.addAttribute("email", iEmailService.findById(id));
        model.addAttribute("languageList", iEmailService.findLanguage());
        model.addAttribute("pageSizeList", iEmailService.findPageSize());
        return "update";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Email email, RedirectAttributes redirectAttributes) {
        iEmailService.update(email);
        redirectAttributes.addFlashAttribute("message", "Chỉnh sửa thành công!");
        return "redirect:/";
    }
}
