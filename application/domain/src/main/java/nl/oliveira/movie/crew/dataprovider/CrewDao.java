package nl.oliveira.movie.crew.dataprovider;

import nl.oliveira.movie.crew.usecase.Crew;

import java.util.Optional;

public interface CrewDao {

  Optional<Crew> findBy(String title);

}
