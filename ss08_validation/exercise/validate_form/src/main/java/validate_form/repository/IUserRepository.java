package validate_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import validate_form.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
