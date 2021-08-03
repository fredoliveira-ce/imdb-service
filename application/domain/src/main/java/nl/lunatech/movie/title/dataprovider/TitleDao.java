package nl.lunatech.movie.title.dataprovider;

import nl.lunatech.movie.title.usecase.Title;

import java.util.List;
import java.util.Optional;

public interface TitleDao {

  List<Title> findByTitle(String title);

  Optional<Title> findById(String titleId);

}
