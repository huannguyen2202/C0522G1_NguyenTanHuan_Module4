package phone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phone_management.model.Phone;

import java.util.Optional;

public interface IPhoneRepository extends JpaRepository<Phone,Long> {
}
