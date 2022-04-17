package nl.oliveira.movie.crew.repository;

import lombok.RequiredArgsConstructor;
import nl.oliveira.movie.crew.dataprovider.CrewDao;
import nl.oliveira.movie.crew.usecase.Crew;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CrewRepository implements CrewDao {

  private final CrewJpaRepository repository;

  @Override
  public Optional<Crew> findBy(String title) {
    return repository.findById(title);
  }
}
