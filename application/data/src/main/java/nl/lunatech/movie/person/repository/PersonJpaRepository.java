package nl.lunatech.movie.person.repository;

import nl.lunatech.movie.person.usecase.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<Person, String> {

  List<Person> findByName(String name);

}
