package spring_security_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_security_example.entity.AppUser;
import spring_security_example.entity.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
