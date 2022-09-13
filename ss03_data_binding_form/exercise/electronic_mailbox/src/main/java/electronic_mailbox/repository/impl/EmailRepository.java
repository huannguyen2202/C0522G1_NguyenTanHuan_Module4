package electronic_mailbox.repository.impl;

import electronic_mailbox.model.Email;
import electronic_mailbox.repository.IEmailRepository;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList = new ArrayList<>();
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        emailList.add(new Email(1, "Vietnamese", 5, true, "Nam"));
        emailList.add(new Email(2, "English", 10, false, "Bao"));
        emailList.add(new Email(3, "Japanese", 15, true, "Hung"));
        emailList.add(new Email(4, "Chinese", 25, false, "An"));
        emailList.add(new Email(5, "Chinese", 50, true, "Dat"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public List<String> findLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> findPageSize() {
        return pageSizeList;
    }

    @Override
    public Email findById(int id) {
        for (Email items : emailList) {
            if (items.getId() == id) {
                return items;
            }
        }

        return null;
    }

    @Override
    public void save(Email email) {
        emailList.add(email);

    }

    @Override
    public void update(Email email) {
        for (Email item : emailList) {
            if (email.getId() == item.getId()) {
                emailList.remove(item);
                emailList.add(email);
                break;
            }
        }

    }
}
