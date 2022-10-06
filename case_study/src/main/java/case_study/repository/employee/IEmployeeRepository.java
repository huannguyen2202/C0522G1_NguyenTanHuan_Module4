package case_study.repository.employee;

import case_study.model.employee.Employee;
import case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Modifying
    @Query(value = "update employee " +
            "set delete_status= 1 " +
            "where employee_id = :keywordId", nativeQuery = true)
    void deleteById(@Param("keywordId") int id);
    @Query(value = "select * " +
            "from employee " +
            "where employee_name like %:name% " +
            "and delete_status=0", nativeQuery = true)
    Page<Employee> searchByName(@Param("name") String name, Pageable pageable);
}
