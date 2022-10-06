package case_study.repository.customer;

import case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Modifying
    @Query(value = "update customer set delete_status= 1 where customer_id = :name", nativeQuery = true)
    void deleteById(@Param("name") int id);

    @Query(value = "select * " +
            "from customer " +
            "where customer_name like %:name%  " +
                "and customer_phone like %:phone% " +
                "and customer_address like %:address% " +
                "and delete_status=0", nativeQuery = true)
    Page<Customer> searchByName(@Param("name") String name,
                                @Param("phone") String phone,
                                @Param("address") String address, Pageable pageable);

}
