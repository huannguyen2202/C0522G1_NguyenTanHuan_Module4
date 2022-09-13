package medical_declaration.service.impl;

import medical_declaration.model.Declaration;
import medical_declaration.repository.IDeclarationRepository;
import medical_declaration.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationService implements IDeclarationService {
    @Autowired
    private IDeclarationRepository iDeclarationRepository;
    @Override
    public List<Declaration> findAll() {
        return iDeclarationRepository.findAll();
    }

    @Override
    public void save(Declaration declaration) {
        iDeclarationRepository.save(declaration);
    }
}
