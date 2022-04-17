package nl.oliveira.sixdegrees.dataprovider;

import nl.oliveira.movie.title.usecase.Title;

import java.util.List;

public interface SixDegreesDao {
  List<Title> loadData(String id);

  List<Title> loadData(int limit, int offset);
}
