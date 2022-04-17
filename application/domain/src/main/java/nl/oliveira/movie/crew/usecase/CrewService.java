package nl.oliveira.movie.crew.usecase;

import lombok.RequiredArgsConstructor;
import nl.oliveira.movie.crew.dataprovider.CrewDao;
import nl.oliveira.movie.person.usecase.Person;
import nl.oliveira.movie.person.usecase.PersonService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class CrewService {

  private final CrewDao dao;
  private final PersonService personService;

  public Crew findBy(final String titleId) {
    return dao.findBy(titleId)
      .map(crew -> crew.toBuilder()
        .directors(findPerson(crew.getDirectors()))
        .writers(findPerson(crew.getWriters()))
        .build())
      .orElseThrow(() -> new CrewNotFoundException(titleId));
  }

  private String findPerson(String people) {
    if (nonNull(people)) {
      return Arrays.stream(people.split(","))
        .map(personService::findBy)
        .map(Person::getName)
        .collect(Collectors.joining(", "));
    }
    return null;
  }

}
