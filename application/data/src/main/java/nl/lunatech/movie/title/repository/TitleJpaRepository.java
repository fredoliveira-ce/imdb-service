package nl.lunatech.movie.title.repository;

import nl.lunatech.movie.title.usecase.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleJpaRepository extends JpaRepository<Title, String> {

  @Query(value =
    "SELECT * FROM title_basics "
      + "WHERE primarytitle ILIKE :title "
      + "OR originaltitle ILIKE :title ",
    nativeQuery = true
  )
  List<Title> findByPrimaryOrOriginalTitle(@Param("title") String title);

}
