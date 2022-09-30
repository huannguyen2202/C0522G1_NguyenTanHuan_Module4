package spring_security_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_security_example.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
