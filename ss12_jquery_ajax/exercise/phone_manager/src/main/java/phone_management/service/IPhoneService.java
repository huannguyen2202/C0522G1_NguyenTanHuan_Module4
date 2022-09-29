package phone_management.service;

import phone_management.model.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhoneService {
    Iterable<Phone> findAll();

    Optional<Phone> findById(Long id);

    Phone save(Phone phone);

    void remove(Long id);

    void update(Phone phone);


}
