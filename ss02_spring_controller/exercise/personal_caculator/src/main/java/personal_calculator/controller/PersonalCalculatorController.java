package personal_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import personal_calculator.service.IPersonalCalculatorService;

@Controller
public class PersonalCalculatorController {
    @Autowired
    IPersonalCalculatorService iPersonalCalculatorService;

    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView convert(@RequestParam String number1, String number2, String calculator) {
        return new ModelAndView("index", "result", iPersonalCalculatorService.result(number1, number2, calculator));
    }
}
