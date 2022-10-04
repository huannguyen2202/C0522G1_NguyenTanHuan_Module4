package case_study.service.employee;

import case_study.model.customer.Customer;
import case_study.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);
}
