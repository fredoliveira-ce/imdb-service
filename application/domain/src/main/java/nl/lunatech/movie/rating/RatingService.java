package nl.lunatech.movie.rating;

import lombok.RequiredArgsConstructor;
import nl.lunatech.movie.rating.dataprovider.RatingDao;
import nl.lunatech.movie.rating.usecase.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

  private final RatingDao dao;

  public List<Rating> findTopRatedBy(final String genre) {
    return dao.findTopRatedByGenre(genre);
  }

}
