package nl.oliveira.movie.title.dataprovider;

import nl.oliveira.movie.title.usecase.Title;

import java.util.List;
import java.util.Optional;

public interface TitleDao {

  List<Title> findByTitle(String title);

  Optional<Title> findById(String titleId);

}
