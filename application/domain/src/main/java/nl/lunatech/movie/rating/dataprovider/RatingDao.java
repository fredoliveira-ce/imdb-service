package nl.lunatech.movie.rating.dataprovider;

import nl.lunatech.movie.rating.usecase.Rating;

import java.util.List;

public interface RatingDao {

  List<Rating> findTopRatedByGenre(String genre);

}
