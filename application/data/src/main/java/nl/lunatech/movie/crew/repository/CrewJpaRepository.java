package nl.lunatech.movie.crew.repository;

import nl.lunatech.movie.crew.usecase.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewJpaRepository extends JpaRepository<Crew, String> {

}
