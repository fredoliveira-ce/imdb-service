package nl.lunatech.movie.cast.repository;

import nl.lunatech.movie.cast.usecase.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CastJpaRepository extends JpaRepository<Cast, String> {

  @Query(value =
      " SELECT * FROM title_principals "
      + "WHERE tconst = :titleId ",
    nativeQuery = true
  )
  List<Cast> findByTitleId(@Param("titleId") String titleId);

  @Query(value =
      " SELECT * FROM title_principals "
      + "WHERE tconst in (:titles) ",
    nativeQuery = true
  )
  List<Cast> findByTitles(@Param("titles") List<String> titles);

  @Query(value =
      " SELECT tconst FROM title_principals "
      + "WHERE nconst = :personId ",
    nativeQuery = true
  )
  List<String> findByPersonId(@Param("personId") String personId);

  @Query(value =
      " SELECT * FROM title_principals "
      + "LIMIT :limit OFFSET :offset",
    nativeQuery = true
  )
  List<Cast> findPaginated(@Param("limit") int limit, @Param("offset") int offset);

}
