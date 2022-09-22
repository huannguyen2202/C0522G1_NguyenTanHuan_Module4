package case_study.controller;

import case_study.dto.CustomerDto;
import case_study.model.Customer;
import case_study.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("customerList", iCustomerService.findAll());
        return "customer/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                       Customer customer, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "customer/create";
        } else {
            Customer customer1 = new Customer();
            BeanUtils.copyProperties(customerDto,customer1);
            iCustomerService.save(customer1);
            redirectAttributes.addFlashAttribute("message","Add new successful!!");
            return "redirect:/customer";
        }
    }
    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable int id, Model model){
        CustomerDto customerDto = new CustomerDto();
        Customer customer= iCustomerService.findById(id);
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                         Customer customer, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "customer/edit";
        } else {
            Customer customer2 = new Customer();
            BeanUtils.copyProperties(customerDto,customer2);
            iCustomerService.update(customer2);
            redirectAttributes.addFlashAttribute("message","Add new successful!!");
            return "redirect:/customer";
        }
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customerList", iCustomerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        iCustomerService.remove(customer.getCustomerId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customerList", iCustomerService.findById(id));
        return "customer/view";
    }
}
