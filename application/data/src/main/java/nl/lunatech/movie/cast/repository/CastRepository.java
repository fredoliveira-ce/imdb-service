package nl.lunatech.movie.cast.repository;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.cast.dataprovider.CastDao;
import nl.lunatech.movie.cast.usecase.Cast;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CastRepository implements CastDao {

  private final CastJpaRepository jpaRepository;

  @Override
  public List<Cast> findByTitle(String titleId) {
    return jpaRepository.findByTitleId(titleId);
  }

  @Override
  public List<Cast> findByTitles(final List<String> titles) {
    return jpaRepository.findByTitles(titles);
  }

  @Override
  public List<String> findByPersonId(String personId) {
    return jpaRepository.findByPersonId(personId);
  }

  @Override
  public List<Cast> findPaginated(int limit, int offset) {
    return jpaRepository.findPaginated(limit, offset);
  }
}
