package medical_declaration.service;

import medical_declaration.model.Declaration;

import java.util.List;

public interface IDeclarationService {
    List<Declaration> findAll();

    void save(Declaration declaration);
}
