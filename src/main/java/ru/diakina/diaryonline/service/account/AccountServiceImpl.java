package ru.diakina.diaryonline.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.diakina.diaryonline.model.Person;
import ru.diakina.diaryonline.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final PersonRepository personRepository;

    @Autowired
    public AccountServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAllAccounts() {
        return personRepository.findAllByStatus(Person.Status.ACTIVE);
    }

    @Override
    public void deleteAccount(Long accountId) {
        Optional<Person> accountOpt = personRepository.findById(accountId);
        if (!accountOpt.isPresent()) {
            throw new UsernameNotFoundException("Аккаунт с таким id не существует");
        }
        //Вытаскиваем аккаунт из его оболочки
        Person account = accountOpt.get();
        //меняем состояние у этого аккаунта на УДАЛЕН
        account.setStatus(Person.Status.DELETED);
        //Сохраняем аккаунт
        personRepository.save(account);
    }

    @Override
    public Person getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getPrincipal().toString();
        Optional<Person> person = personRepository.findByEmail(email);
        return person.orElse(null);
    }
}
