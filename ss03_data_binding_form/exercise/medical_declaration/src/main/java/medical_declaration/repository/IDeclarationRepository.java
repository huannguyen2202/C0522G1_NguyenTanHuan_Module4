package medical_declaration.repository;

import medical_declaration.model.Declaration;

import java.util.List;

public interface IDeclarationRepository {
    List<Declaration> findAll();

    void save(Declaration declaration);
}
