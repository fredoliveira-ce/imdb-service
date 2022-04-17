package nl.oliveira.sixdegrees;

import lombok.RequiredArgsConstructor;
import nl.oliveira.movie.cast.usecase.Cast;
import nl.oliveira.movie.cast.usecase.CastService;
import nl.oliveira.movie.person.usecase.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovieMatcher {

  private final CastService castService;

  public Optional<Cast> hasMatch(final List<Cast> actor, final List<Cast> actorTarget) {
    return actor.stream()
      .filter(cast -> actorTarget.stream()
        .anyMatch(target -> cast.getTitleId().equals(target.getTitleId())))
      .findAny();
  }

  //@SneakyThrows
  public void checkFirstMatch(final Person source, final Person target) {
    /*final ExecutorService service = Executors.newFixedThreadPool(2);
    root.setSourceCasts(service.submit(() -> castService.findByPerson(source.getId())).get());
    root.setTargetCasts(service.submit(() -> castService.findByPerson(target.getId())).get());

    return hasMatch(root.getSourceCasts(), root.getTargetCasts());*/
  }
}
