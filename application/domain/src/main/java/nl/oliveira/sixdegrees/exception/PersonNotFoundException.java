package nl.oliveira.sixdegrees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException(String personId) {
    super(String.format("%s was not found!", personId));
  }

}
