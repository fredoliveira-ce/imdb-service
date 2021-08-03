package nl.lunatech.movie.rating.repository;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.rating.dataprovider.RatingDao;
import nl.lunatech.movie.rating.usecase.Rating;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RatingRepository implements RatingDao {

  private final RatingJpaRepository jpaRepository;

  @Override
  public List<Rating> findTopRatedByGenre(String genre) {
    return jpaRepository.findTopRatedByGenre(genre);
  }

}
