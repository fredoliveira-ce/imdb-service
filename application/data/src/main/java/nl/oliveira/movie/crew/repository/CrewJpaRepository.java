package nl.oliveira.movie.crew.repository;

import nl.oliveira.movie.crew.usecase.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewJpaRepository extends JpaRepository<Crew, String> {

}
