package validate_form.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import validate_form.dto.UserDto;
import validate_form.model.User;
import validate_form.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult, User user, RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            User user1 = new User();
            BeanUtils.copyProperties(userDto, user1);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("message", "Create blog: " + user.getFirstName() + " OK!");
            return "redirect:/user";
        }
    }
}
