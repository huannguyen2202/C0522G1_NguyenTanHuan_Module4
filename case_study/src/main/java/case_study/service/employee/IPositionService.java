package case_study.service.employee;

import case_study.model.employee.Employee;
import case_study.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
