package case_study.service.employee;

import case_study.model.employee.Division;
import case_study.model.employee.Employee;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
