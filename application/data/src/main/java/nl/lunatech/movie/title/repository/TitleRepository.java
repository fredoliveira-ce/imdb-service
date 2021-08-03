package nl.lunatech.movie.title.repository;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.title.dataprovider.TitleDao;
import nl.lunatech.movie.title.usecase.Title;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TitleRepository implements TitleDao {

  private final TitleJpaRepository repository;

  @Override
  public List<Title> findByTitle(final String title) {
    return repository.findByPrimaryOrOriginalTitle(title);
  }

  @Override
  public Optional<Title> findById(final String titleId) {
    return repository.findById(titleId);
  }

}
