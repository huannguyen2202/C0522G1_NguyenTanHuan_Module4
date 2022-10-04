package case_study.repository.employee;

import case_study.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
