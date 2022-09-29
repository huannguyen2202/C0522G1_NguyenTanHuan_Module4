package phone_management.service;

import phone_management.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();

    Phone findById(int id);

    Phone save(Phone phone);

    void remove(int id);


}
