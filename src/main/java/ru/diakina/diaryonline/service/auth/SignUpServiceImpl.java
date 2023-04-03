package ru.diakina.diaryonline.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.diakina.diaryonline.dto.SignUpForm;
import ru.diakina.diaryonline.model.Person;
import ru.diakina.diaryonline.repository.PersonRepository;
import ru.diakina.diaryonline.service.auth.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final PersonRepository personRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(PersonRepository personRepository,
                             PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(SignUpForm dto) {
        Person account = Person.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Person.Role.USER)
                .status(Person.Status.ACTIVE)
                .build();

        personRepository.save(account);
    }
}
