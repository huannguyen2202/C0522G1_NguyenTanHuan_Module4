package validate_form.service;

import validate_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
