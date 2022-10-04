package case_study.service.customer.impl;

import case_study.model.customer.Customer;
import case_study.repository.customer.ICustomerRepository;
import case_study.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByName(String name,String phone,String address,Pageable pageable) {
        return iCustomerRepository.searchByName(name,phone,address,pageable);
    }
}
