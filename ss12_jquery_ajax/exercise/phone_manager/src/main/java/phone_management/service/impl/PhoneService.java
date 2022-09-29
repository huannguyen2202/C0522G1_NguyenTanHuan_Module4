package phone_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import phone_management.model.Phone;
import phone_management.repository.IPhoneRepository;
import phone_management.service.IPhoneService;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneRepository iPhoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findById(Long id) {
        return iPhoneRepository.findById(id);
    }

    @Override
    public Phone save(Phone phone) {
        return iPhoneRepository.save(phone);
    }

    @Override
    public void remove(Long id) {
        iPhoneRepository.deleteById(id);

    }

    @Override
    public void update(Phone phone) {
        iPhoneRepository.save(phone);

    }
}
