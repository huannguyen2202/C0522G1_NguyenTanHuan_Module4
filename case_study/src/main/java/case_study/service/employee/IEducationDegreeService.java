package case_study.service.employee;

import case_study.model.employee.EducationDegree;
import case_study.model.employee.Employee;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();
}
