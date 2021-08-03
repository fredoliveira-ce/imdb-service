package nl.lunatech.movie.person.repository;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.person.dataprovider.PersonDao;
import nl.lunatech.movie.person.usecase.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonDao {

  private final PersonJpaRepository repository;

  @Override
  public Optional<Person> findBy(String id) {
    return repository.findById(id);
  }

  @Override
  public List<Person> findByName(String name) {
    return repository.findByName(name);
  }

}
