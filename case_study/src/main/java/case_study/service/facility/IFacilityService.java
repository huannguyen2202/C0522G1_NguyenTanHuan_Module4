package case_study.service.facility;

import case_study.model.customer.Customer;
import case_study.model.facility.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Facility findById(int id);

    void update(Facility facility);

    void remove(int id);
}
