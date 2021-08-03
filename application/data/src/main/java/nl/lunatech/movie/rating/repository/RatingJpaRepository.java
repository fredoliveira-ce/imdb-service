package nl.lunatech.movie.rating.repository;

import nl.lunatech.movie.rating.usecase.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingJpaRepository extends JpaRepository<Rating, String> {

  @Query(value =
      " SELECT tr.tconst, tr.averagerating, tr.numvotes, tb.primarytitle as title, tb.genres"
      + " FROM title_ratings tr "
      + " JOIN title_basics tb on tr.tconst = tb.tconst "
      + "WHERE tb.genres ILIKE %:genre% "
      + "ORDER BY tr.averagerating desc, tr.numvotes desc "
      + "LIMIT 10",
    nativeQuery = true
  )
  List<Rating> findTopRatedByGenre(@Param("genre") String genre);
}
