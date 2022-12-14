package case_study.service.facility.impl;

import case_study.model.facility.Facility;
import case_study.repository.facility.IFacilityRepository;
import case_study.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public Facility findById(int id) {

        return iFacilityRepository.findById(id).get();
    }

    @Override
    public void update(Facility facility) {
        iFacilityRepository.save(facility);
    }

    @Override
    public void remove(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findByName(String name, Pageable pageable) {
        return iFacilityRepository.searchByName(name,pageable);
    }


}
