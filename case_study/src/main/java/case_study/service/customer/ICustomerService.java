package case_study.service.customer;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);

    Page<Customer> findByName(String name, String phone,String address, Pageable pageable);
}
