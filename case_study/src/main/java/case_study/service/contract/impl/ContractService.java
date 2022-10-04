package case_study.service.contract.impl;

import case_study.dto.IContractDto;
import case_study.model.contract.Contract;
import case_study.repository.contract.IContractRepository;
import case_study.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<IContractDto> findAllDto() {
        return iContractRepository.findAllDto();
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }
}
