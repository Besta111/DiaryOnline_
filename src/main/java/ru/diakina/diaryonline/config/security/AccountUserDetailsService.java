package ru.diakina.diaryonline.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.diakina.diaryonline.repository.PersonRepository;

@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public AccountUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(
                personRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Not found account!"))
        );
    }
}
