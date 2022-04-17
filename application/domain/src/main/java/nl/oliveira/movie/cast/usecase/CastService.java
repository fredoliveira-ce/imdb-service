package nl.oliveira.movie.cast.usecase;

import lombok.RequiredArgsConstructor;
import nl.oliveira.movie.cast.dataprovider.CastDao;
import nl.oliveira.movie.person.usecase.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class CastService {

  private final CastDao dao;
  private final PersonService personService;

  public List<Cast> findByTitle(final String titleId) {
    return dao.findByTitle(titleId).stream()
            .map(this::findPerson)
            .collect(Collectors.toList());
  }

  public Map<String, List<Cast>> findByTitles(final List<String> titles) {
    return dao.findByTitles(titles)
      .stream()
      .collect(groupingBy(Cast::getTitleId));
  }

  public Map<String, List<Cast>> findPaginated(int limit, int offset) {
    return dao.findPaginated(limit, offset)
      .stream()
      .collect(groupingBy(Cast::getTitleId));
  }

  public List<String> findByTitlesByPersonId(String personId) {
    return dao.findByPersonId(personId);
  }

  private Cast findPerson(final Cast cast) {
    return cast.toBuilder()
      .person(personService.findBy(cast.getPersonId()))
      .build();
  }
}
