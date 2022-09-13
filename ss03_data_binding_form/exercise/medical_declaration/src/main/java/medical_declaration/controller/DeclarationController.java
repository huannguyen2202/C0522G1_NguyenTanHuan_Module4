package medical_declaration.controller;

import medical_declaration.model.Declaration;
import medical_declaration.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("/")
    public ModelAndView showDeclaration() {
        return new ModelAndView("list", "declarationList", iDeclarationService.findAll());
    }

    @GetMapping("/save")
    public String formDeclaration(Model model) {
        model.addAttribute("declaration", new Declaration());
        return "form";
    }

    @PostMapping("/save")
    public String declaration(@ModelAttribute Declaration declaration, RedirectAttributes redirectAttributes) {
        iDeclarationService.save(declaration);
        redirectAttributes.addFlashAttribute("massage", "Nhập thông tin thành công!!!");
        return "redirect:/";
    }
}
