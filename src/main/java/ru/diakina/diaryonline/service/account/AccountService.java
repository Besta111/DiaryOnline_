package ru.diakina.diaryonline.service.account;

import ru.diakina.diaryonline.model.Person;

import java.util.List;

public interface AccountService {

    List<Person> findAllAccounts();

    void deleteAccount(Long accountId);

    Person getCurrentUser();
}
