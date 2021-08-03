package nl.lunatech.movie.crew.dataprovider;

import nl.lunatech.movie.crew.usecase.Crew;

import java.util.Optional;

public interface CrewDao {

  Optional<Crew> findBy(String title);

}
