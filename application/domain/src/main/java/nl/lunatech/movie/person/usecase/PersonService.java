package nl.lunatech.movie.person.usecase;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.person.PersonNotFoundException;
import nl.lunatech.movie.person.dataprovider.PersonDao;
import nl.lunatech.movie.title.TitleNotFoundException;
import nl.lunatech.movie.title.dataprovider.TitleDao;
import nl.lunatech.movie.title.usecase.Title;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonDao dao;
  private final TitleDao titleDao;

  public Person findBy(final String personId) {
    return dao.findBy(personId)
      .map(person -> person.toBuilder()
        .fortitles(findParticipation(person.getFortitles()))
        .build())
      .orElseThrow(() -> new PersonNotFoundException(personId));
  }

  private String findParticipation(final String fortitles) {
    if (nonNull(fortitles)) {
      return Arrays.stream(fortitles.split(","))
        .map(this::findTitle)
        .map(Title::getOriginalTitle)
        .collect(Collectors.joining(", "));
    }
    return null;
  }

  private Title findTitle(final String id) {
    return titleDao.findById(id)
      .orElseThrow(() -> new TitleNotFoundException(id));
  }

}
