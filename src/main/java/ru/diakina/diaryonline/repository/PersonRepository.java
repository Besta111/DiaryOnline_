package ru.diakina.diaryonline.repository;

import ru.diakina.diaryonline.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    List<Person> findAllByStatus(Person.Status status);

    Person findPersonByUsernameAndPassword(String username, String password);

}
