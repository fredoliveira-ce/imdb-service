package nl.oliveira.sixdegrees;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.oliveira.movie.person.PersonNotFoundException;
import nl.oliveira.movie.person.dataprovider.PersonDao;
import nl.oliveira.movie.person.usecase.Person;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Slf4j
@Service
@RequiredArgsConstructor
public class SixDegreesValidator {

  private final PersonDao personDao;

  public Person validateActor(String person) {
    return personDao.findByName(person).stream()
      //FIXME How to define when there are more than one to choose? Should be given to the user decide it?
      .max(Comparator.comparingInt(Person::getBirthYear))
      .orElseThrow(() -> new PersonNotFoundException(person));
  }

}
