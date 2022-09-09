package dictionary.service.impl;

import dictionary.model.Dictionary;
import dictionary.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    private static Map<Integer, Dictionary> dictionaries = new HashMap<>();

    static {
        dictionaries.put(1, new Dictionary("hello", "xin chao"));
        dictionaries.put(2, new Dictionary("dog", "con cho"));
        dictionaries.put(3, new Dictionary("cat", "con meo"));
        dictionaries.put(4, new Dictionary("banana", "qua tao"));
        dictionaries.put(5, new Dictionary("goodbye", "tam biet"));
        dictionaries.put(6, new Dictionary("rat", "con chuot"));
    }

    @Override
    public List<Dictionary> findAll() {

        return new ArrayList<>(dictionaries.values());
    }
}
