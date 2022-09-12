package currencyConversion.controller;

import currencyConversion.service.ICurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @Autowired
    private ICurrencyConversionService iCurrencyConversionService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @PostMapping("/usd")
    public String submit(@RequestParam String usd, Model model) {
        double result = iCurrencyConversionService.covert(usd);
        model.addAttribute("result", result);
        return "/index";
    }
}
