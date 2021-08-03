package nl.lunatech.movie.person.dataprovider;

import nl.lunatech.movie.person.usecase.Person;

import java.util.List;
import java.util.Optional;

public interface PersonDao {

  Optional<Person> findBy(String id);

  List<Person> findByName(String name);

}
