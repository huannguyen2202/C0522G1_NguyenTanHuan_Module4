package electronic_mailbox.service;

import electronic_mailbox.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();

    List<String> findLanguage();

    List<Integer> findPageSize();

    Email findById(int id);

    void save(Email email);

    void update(Email email);
}
