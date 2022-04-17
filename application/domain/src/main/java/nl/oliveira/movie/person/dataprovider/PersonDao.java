package nl.oliveira.movie.person.dataprovider;

import nl.oliveira.movie.person.usecase.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

  Optional<Person> findBy(String id);

  List<Person> findByName(String name);

}
