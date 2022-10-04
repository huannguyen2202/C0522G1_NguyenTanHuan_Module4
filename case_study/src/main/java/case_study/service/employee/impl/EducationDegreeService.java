package case_study.service.employee.impl;

import case_study.model.employee.EducationDegree;
import case_study.model.employee.Employee;
import case_study.repository.employee.IEducationDegreeRepository;
import case_study.service.employee.IEducationDegreeService;
import case_study.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;


    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
