package case_study.controller;

import case_study.dto.CustomerDto;
import case_study.dto.FacilityDto;
import case_study.model.customer.Customer;
import case_study.model.facility.Facility;
import case_study.service.facility.IFacilityService;
import case_study.service.facility.IFacilityTypeService;
import case_study.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IFacilityTypeService iFacilityTypeService;

    @Autowired
    private IRentTypeService iRentTypeService;

    //    @GetMapping("")
//    public String list(Model model){
//        model.addAttribute("facilityList", iFacilityService.findAll());
//        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
//        model.addAttribute("rentTypeList",iRentTypeService.findAll());
//        return "facility/list";
//    }
    @GetMapping("")
    public String search(@RequestParam(defaultValue = "") String name,
                         @PageableDefault(value = 5) Pageable pageable, Model model) {
        model.addAttribute("facilityList", iFacilityService.findByName(name, pageable));
        model.addAttribute("name", name);
        return "facility/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("facilityDto", new FacilityDto());
        return "facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                       Facility facility, RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "facility/create";
        } else {
            Facility facility1 = new Facility();
            BeanUtils.copyProperties(facilityDto, facility1);
            iFacilityService.save(facility1);
            redirectAttributes.addFlashAttribute("message", "Add new successful!!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/edit")
    public String editCustomer(@PathVariable int id, Model model) {
        FacilityDto facilityDto = new FacilityDto();
        Facility facility = iFacilityService.findById(id);
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        model.addAttribute("facilityDto", facilityDto);
        return "facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                         Facility facility, RedirectAttributes redirectAttributes) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "facility/edit";
        } else {
            Facility facility2 = new Facility();
            BeanUtils.copyProperties(facilityDto, facility2);
            iFacilityService.update(facility2);
            redirectAttributes.addFlashAttribute("message", "Add new successful!!");
            return "redirect:/facility";
        }
    }

    //    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable int id, Model model) {
//        model.addAttribute("facilityList", iFacilityService.findById(id));
//        return "facility/delete";
//    }
//
//    @PostMapping("/delete")
//    public String delete(Facility facility, RedirectAttributes redirect) {
//        iFacilityService.remove(facility.getFacilityId());
//        redirect.addFlashAttribute("success", "Removed facility successfully!");
//        return "redirect:/facility";
//    }
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") int id, RedirectAttributes redirect) {
        iFacilityService.remove(id);
        redirect.addFlashAttribute("success", "Removed facility successfully!");
        return "redirect:/facility";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("facilityList", iFacilityService.findById(id));
        return "facility/view";
    }
}
