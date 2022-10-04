package case_study.controller;

import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.service.contract.IAttachFacilityService;
import case_study.service.contract.IContractDetailService;
import case_study.service.contract.IContractService;
import case_study.service.customer.ICustomerService;
import case_study.service.employee.IEmployeeService;
import case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private IFacilityService iFacilityService;

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(Model model) {
        List<Contract> contractList = iContractService.findAll();
        for (Contract contract : contractList) {
            if (contract.getStartDate().contains("-")) {
                String[] arr = contract.getStartDate().split("-");
                contract.setStartDate(arr[2] + "/" + arr[1] + "/" + arr[0]);
            }

            if (contract.getEndDate().contains("-")) {
                String[] arr = contract.getEndDate().split("-");
                contract.setEndDate(arr[2] + "/" + arr[1] + "/" + arr[0]);
            }
        }

        model.addAttribute("contractList", iContractService.findAllDto());
        model.addAttribute("attachFacilityList", iAttachFacilityService.findAll());
        model.addAttribute("contractDetailList", iContractDetailService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());

        LocalDate minAge = LocalDate.now();
        model.addAttribute("minAge", minAge);

        return "contract/list";
    }






}
