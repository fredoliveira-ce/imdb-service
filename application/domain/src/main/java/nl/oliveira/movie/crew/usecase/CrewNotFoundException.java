package nl.oliveira.movie.crew.usecase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CrewNotFoundException extends RuntimeException {

  public CrewNotFoundException(String titleId) {
    super(String.format("Crew for the title id '%s' not found.", titleId));
  }

}
