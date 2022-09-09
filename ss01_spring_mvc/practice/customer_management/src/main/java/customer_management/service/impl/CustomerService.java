package customer_management.service.impl;

import customer_management.model.Customer;
import customer_management.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerService implements ICustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;

    static {
        customers = Arrays.asList(
                new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"),
                new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"),
                new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"),
                new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"),
                new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang")
        );
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}
