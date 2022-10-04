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
    @Query(value = "update customer set delete_status= 1 where customer_id = :keywordId", nativeQuery = true)
    void deleteById(@Param("keywordId") int id);

    @Query(value = "select * from customer where customer_name like %:keyword%  and customer_phone like %:keyword1% and customer_address like %:keyword2% and delete_status=0", nativeQuery = true)
    Page<Customer> searchByName(@Param("keyword") String name, @Param("keyword1") String phone, @Param("keyword2") String address, Pageable pageable);

}
