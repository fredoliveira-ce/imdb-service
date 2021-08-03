package nl.lunatech.movie.title.usecase;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.cast.usecase.CastService;
import nl.lunatech.movie.crew.usecase.CrewService;
import nl.lunatech.movie.title.dataprovider.TitleDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TitleService {

  private final TitleDao dao;
  private final CastService castService;
  private final CrewService crewService;

  public List<Title> findByTitle(final String title) {
    return dao.findByTitle(title).stream()
      .map(this::findCast)
      .map(this::findCrew)
      .collect(Collectors.toList());
  }

  private Title findCast(final Title title) {
    return title.toBuilder()
      .cast(castService.findByTitle(title.getId()))
      .build();
  }

  private Title findCrew(final Title title) {
    return title.toBuilder()
      .crew(crewService.findBy(title.getId()))
      .build();
  }

}
