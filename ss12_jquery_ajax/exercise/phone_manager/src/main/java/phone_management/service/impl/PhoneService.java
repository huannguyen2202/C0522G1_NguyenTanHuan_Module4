package phone_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone_management.model.Phone;
import phone_management.repository.IPhoneRepository;
import phone_management.service.IPhoneService;

import java.util.List;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public List<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Phone findById(int id) {
        return iPhoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return iPhoneRepository.save(phone);
    }

    @Override
    public void remove(int id) {
        iPhoneRepository.delete(findById(id));
    }
}
