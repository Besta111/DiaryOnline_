package ru.diakina.diaryonline.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.diakina.diaryonline.model.Person;

import java.util.Collection;
import java.util.Collections;

public class AccountUserDetails implements UserDetails {

    private final Person person;

    public AccountUserDetails(Person person) {
        this.person = person;
    }

    //Какие права у пользователя?
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = person.getRole().name();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        return Collections.singleton(authority);
    }

    //Какой пароль у пользователя?
    @Override
    public String getPassword() {
        return person.getPassword();
    }

    //Какой username у пользователя?
    @Override
    public String getUsername() {
        return person.getEmail();
    }

    //Не просрочен ли аккаунт?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //Не заблокирован ли аккаунт?
    @Override
    public boolean isAccountNonLocked() {
        return !person.getStatus().equals(Person.Status.BANNED);
    }

    //Не просрочены ли креды?
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //Активен ли аккаунт?
    @Override
    public boolean isEnabled() {
        return person.getStatus().equals(Person.Status.ACTIVE);
    }
}
