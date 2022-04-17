package nl.oliveira.sixdegrees;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.oliveira.movie.cast.usecase.Cast;
import nl.oliveira.movie.cast.usecase.CastService;
import nl.oliveira.movie.title.usecase.Title;
import nl.oliveira.sixdegrees.dataprovider.SixDegreesDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class DataLoader implements SixDegreesDao {
  private final CastService castService;

  public List<Title> loadData(String fromPersonId) {
    log.info("Load data from {}", fromPersonId);
    List<String> titles = castService.findByTitlesByPersonId(fromPersonId);

    return castService.findByTitles(titles).entrySet()
      .stream()
      .map(this::buildTitle)
      .collect(Collectors.toList());
  }

  @Override
  public List<Title> loadData(int limit, int offset) {
    return castService.findPaginated(limit, offset).entrySet()
      .stream()
      .map(this::buildTitle)
      .collect(Collectors.toList());
  }

  private Title buildTitle(Map.Entry<String, List<Cast>> title) {
    return Title.builder()
      .id(title.getKey())
      .cast(title.getValue())
      .build();
  }
}
