package nl.lunatech.movie.cast.dataprovider;

import nl.lunatech.movie.cast.usecase.Cast;

import java.util.List;

public interface CastDao {

  List<Cast> findByTitle(String title);

  List<Cast> findByTitles(List<String> titles);

  List<String> findByPersonId(String personId);

  List<Cast> findPaginated(int limit, int offset);
}
