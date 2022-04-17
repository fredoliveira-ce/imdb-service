package nl.oliveira.movie.rating.dataprovider;

import nl.oliveira.movie.rating.usecase.Rating;

import java.util.List;

public interface RatingDao {

  List<Rating> findTopRatedByGenre(String genre);

}
