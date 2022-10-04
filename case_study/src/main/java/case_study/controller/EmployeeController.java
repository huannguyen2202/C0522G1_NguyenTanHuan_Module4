package case_study.controller;

import case_study.dto.CustomerDto;
import case_study.dto.EmployeeDto;
import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.service.employee.IDivisionService;
import case_study.service.employee.IEducationDegreeService;
import case_study.service.employee.IEmployeeService;
import case_study.service.employee.IPositionService;
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

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String list(Model model){
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("divisionList",iDivisionService.findAll());
        model.addAttribute("educationDegreeList",iEducationDegreeService.findAll());
        model.addAttribute("positionList",iPositionService.findAll());
        return "employee/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList",iDivisionService.findAll());
        model.addAttribute("educationDegreeList",iEducationDegreeService.findAll());
        model.addAttribute("positionList",iPositionService.findAll());
        return "employee/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult,
                       Employee employee, RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "employee/create";
        } else {
            Employee employee1 = new Employee();
            BeanUtils.copyProperties(employeeDto,employee1);
            iEmployeeService.save(employee1);
            redirectAttributes.addFlashAttribute("message","Add new successful!!");
            return "redirect:/employee";
        }
    }
}
