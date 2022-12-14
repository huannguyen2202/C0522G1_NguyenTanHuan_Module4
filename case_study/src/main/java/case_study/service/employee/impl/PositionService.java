package case_study.service.employee.impl;

import case_study.model.employee.Position;
import case_study.repository.employee.IPositionRepository;
import case_study.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository iPositionRepository;


    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
