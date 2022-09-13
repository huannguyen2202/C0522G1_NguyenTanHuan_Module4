package medical_declaration.repository.impl;

import medical_declaration.model.Declaration;
import medical_declaration.repository.IDeclarationRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeclarationRepository implements IDeclarationRepository {
    private List<Declaration> declarationList = new ArrayList<>();

    @Override
    public List<Declaration> findAll() {
        return declarationList;
    }

    @Override
    public void save(Declaration declaration) {
        declarationList.add(declaration);
    }
}
