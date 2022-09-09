package dictionary.service;

import dictionary.model.Dictionary;

import java.util.List;

public interface IDictionaryService {
    List<Dictionary> findAll();
}
