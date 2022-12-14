package sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping("/")
    public String loadSave() {
        return "save";
    }


    @GetMapping(path = "/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, ModelMap modelMap) {
        if (condiment.length == 0) {
            modelMap.addAttribute("condiment", "Bạn chưa chọn loại gia vị!!!");
        } else {
            modelMap.addAttribute("condiment", condiment);
        }
        return "save";
    }
}
