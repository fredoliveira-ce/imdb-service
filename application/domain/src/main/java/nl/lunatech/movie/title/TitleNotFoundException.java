package nl.lunatech.movie.title;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TitleNotFoundException extends RuntimeException {

  public TitleNotFoundException(String titleId) {
    super(String.format("Title with id '%s' not found.", titleId));
  }

}
