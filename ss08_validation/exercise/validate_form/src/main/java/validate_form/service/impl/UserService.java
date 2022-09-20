package validate_form.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import validate_form.model.User;
import validate_form.repository.IUserRepository;
import validate_form.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
