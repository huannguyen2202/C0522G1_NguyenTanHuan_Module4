package phone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone_management.model.Phone;

public interface IPhoneRepository extends JpaRepository<Phone,Integer> {
    Phone findById(int id);
}
